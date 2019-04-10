package com.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.message.service.MessageService;
import com.studio.work.dubbo.dto.WorkStudio;
import com.studio.work.dubbo.service.StudioWorkService;
import com.user.dubbo.dto.User;
import com.user.dubbo.dto.UserCompany;
import com.user.dubbo.dto.UserStudio;
import com.user.dubbo.service.CompanyService;
import com.user.dubbo.service.StudioService;
import com.user.dubbo.service.UserService;
import com.user.redis.RedisClient;
import com.user.response.LoginResponse;
import com.user.response.Response;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;

@Controller
@RequestMapping("/user")
public class UserController {
    @Reference
    private UserService userService;

    @Reference
    private MessageService messageService;

    @Reference
    private CompanyService companyService;

    @Reference
    private StudioService studioService;

    @Autowired
    private RedisClient redisClient;



    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/regedit",method = RequestMethod.GET)
    public String regedit(){
        return "regedit";
    }

    @RequestMapping(value = "/swregister",method = RequestMethod.GET)
    public String swregister(){
        return "swregister";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Response login(@RequestParam String  userid,@RequestParam String password){
        User user =null;
        try {
            user= userService.selectByUid(userid);

        }catch (Exception e){
            e.printStackTrace();
            return Response.USER_OR_PASSWORD_ERR;
        }
        if(user==null){
            return Response.USER_OR_PASSWORD_ERR;
        }
        if(!user.getPassword().equalsIgnoreCase(md5(password))) {
            return Response.USER_OR_PASSWORD_ERR;
        }
        String token=getToken();
        redisClient.set(token,user,3600);

        LoginResponse loginResponse = new LoginResponse(token);
        loginResponse.setCode(user.getState().toString());
        return loginResponse;
    }


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    //注册 state:1-公司 ，2-工作室
    public Response register(@RequestParam("userid") String userid,
                             @RequestParam("password") String password,
                             @RequestParam(value = "mobile",required = false) String mobile,
                             @RequestParam(value = "email",required = false) String email,
                             @RequestParam("state") Integer state,
                             @RequestParam("verifyCode") String verifyCode){

        User user =userService.selectByUid(userid);

        if(user!=null)
            return Response.USERID_IS_EXIST;

        user=new User();
        if(StringUtils.isNotBlank(email)){
            String code=(String)redisClient.get("email");

            if(code.equals(verifyCode)){
                user.setEmail(email);
            }else {
                return Response.VERIFYCODE_ERR;
            }
        }else {
            String code =(String) redisClient.get("mobile");

            if(code.equals(verifyCode)){
                user.setMobile(mobile);
            }else {
                return Response.VERIFYCODE_ERR;
            }
        }

        user.setUserid(userid);
        user.setPassword(md5(password));

        user.setState(state);

        userService.regiserUser(user);
        Integer id= userService.selectByUid(userid).getId();
        if(state==1){
            UserCompany company=new UserCompany();
            company.setUserId(id);
            company.setRegistertime(new Date());

            companyService.registerCompany(company);
        }
        if(state==2){
            UserStudio studio=new UserStudio();
            studio.setUserId(id);
            studio.setRegistertime(new Date());
            studioService.registerStudio(studio);
        }

        return new Response();
    }

        @RequestMapping(value = "/sendVerifyCode",method = RequestMethod.POST)
    @ResponseBody
    public Response sendVerifyCode(@RequestParam(value = "mobile",required = false) String mobile,
                                   @RequestParam(value = "email",required = false) String email){
        int state=0;
        String code=randomCode("0123456789",6);
        if(StringUtils.isNotBlank(mobile)){
            state=1;
            try {
                boolean sendVerifyCode = messageService.sendMobileMessage(mobile, code);
                if (sendVerifyCode){
                    redisClient.set("mobile",code);
                }else {
                    System.out.println("发送失败");
                    return Response.MOBILE_SEND_ERR;
                }

            }catch (Exception e){
                e.printStackTrace();
                return Response.MOBILE_SEND_ERR;
            }

        }

        if(StringUtils.isNotBlank(email)){
            state=1;
            try{
                boolean sendVerifyCode = messageService.sendEmailMessage(email, code, "sendVerifyCode");
                if(sendVerifyCode){
                    redisClient.set("email",code);
                }else {
                    System.out.println("发送失败");
                    return Response.MOBILE_SEND_ERR;
                }

            }catch (Exception e){
                e.printStackTrace();
                return Response.EMAIL_SEND_ERR;
            }
        }
        if(state==0)
            return Response.EMAIL_AND_MOBILE_NULL;
        else
            return new Response();
    }

    @RequestMapping(value = "/authentication",method = RequestMethod.POST)
    @ResponseBody
    public User authentication(@RequestHeader("token") String token){
        return redisClient.get(token);
    }

    private String getToken(){
        return randomCode("0123456789abcdefghijklmnopqistuvwxyz",32);
    }
    private String randomCode(String a,int size){
        StringBuffer result=new StringBuffer(size);
        Random random=new Random();
        for(int i=0;i<size;i++){
            int ioc=random.nextInt(a.length());
            result.append(a.charAt(ioc));
        }
        return result.toString();
    }
    private String md5(String password){
        try {
            MessageDigest md5=MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(password.getBytes("utf-8"));
            return HexUtils.toHexString(digest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
