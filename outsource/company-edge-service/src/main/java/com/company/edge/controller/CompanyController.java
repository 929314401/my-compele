package com.company.edge.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.company.edge.redis.RedisClient;
import com.company.edge.response.*;
import com.payment.dubbo.dto.PayMessage;
import com.payment.dubbo.service.PaymentMessageService;
import com.project.dubbo.dto.PageBean;
import com.project.dubbo.dto.PjInformation;
import com.project.dubbo.dto.StartStudio;
import com.project.dubbo.dto.StudioApply;
import com.project.dubbo.service.PjInformationService;
import com.project.dubbo.service.StudioApplyService;
import com.user.dubbo.dto.CompanyDTO;
import com.user.dubbo.dto.User;
import com.user.dubbo.dto.UserCompany;
import com.user.dubbo.dto.UserStudio;
import com.user.dubbo.service.CompanyService;
import com.user.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Reference
    private PaymentMessageService paymentMessageService;

    @Reference
    private PjInformationService pjInformationService;

    @Reference
    private UserService userService;

    @Reference
    private CompanyService companyService;


    @Reference
    private StudioApplyService studioApplyService;


    @Value("${nest.payment.proportion}")
    private Double proportion;

    @Autowired
    private RedisClient redisClient;


    @RequestMapping(value = "/selectOwn")
    @ResponseBody
    public UserResponse<UserCompany> selectOwn(HttpServletRequest request,
                                               @RequestParam String token){
        Integer id=getUserid(request);
        UserCompany company =
                    companyService.selectByuserid(id);
        //System.out.println(company.getRegistertime());
        return new UserResponse<>(token,company);
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/sendProject")
    public String sendProject(){
        return "sendProject";
    }

    @RequestMapping("/allproject")
    public String allproject(){
        return "allproject";
    }

    @RequestMapping(value = "/liststudio/{id}",method = RequestMethod.GET)
    public String liststudio(@PathVariable Integer id,HttpSession session){
        session.setAttribute("project_id",id);

        Integer project_id =(Integer) session.getAttribute("project_id");
        System.out.println(project_id);
        return "liststudio";
    }


    @RequestMapping(value = "/updateOwn",method = RequestMethod.POST)
    @ResponseBody
    public Response updateOwn(@RequestBody UserCompany company,
                              @RequestParam String token,
                              HttpServletRequest request){
        System.out.println(company.getRegistertime());
        System.out.println(token);
        company.setUserId(getUserid(request));
        companyService.updateCompany(company);
        return new LoginResponse(token);
    }


    @RequestMapping(value = "/sendproject",method = RequestMethod.POST)
    @ResponseBody
    public Response sendproject(@RequestBody PjInformation project,
                                @RequestParam String token,
                                HttpServletRequest request){

        project.setBid(0);
        project.setCompanyid(getUserid(request));
        try{
            pjInformationService.registerProject(project);

        }catch (Exception e){
            Response response = new Response();
            response.setMessage("错误");
            return response;
        }

        return new LoginResponse(token);
    }

    //查看该账号的所以项目
    @RequestMapping(value = "/listproject",method =RequestMethod.POST)
    @ResponseBody
    public PageBean<PjInformation> listproject(@RequestParam Integer page,
                                           @RequestParam Integer rows,
                                           HttpServletRequest request){
        Integer userid = getUserid(request);
        PageBean<PjInformation> pageBean = pjInformationService.selectByworkId(userid, page, rows);
        return pageBean;
    }


    //通过项目id 查看有哪些工作室进行投标
    @RequestMapping(value = "/listStudio",method = RequestMethod.POST)
    @ResponseBody
    public PageBean<StartStudio> listStudio(@RequestParam Integer page,
                                        @RequestParam Integer rows,
                                        HttpSession session){

        Integer project_id = (Integer) session.getAttribute("project_id");

        PageBean<StudioApply> pageBean = studioApplyService.selectByProjectId(project_id, page, rows);

        PageBean<StartStudio> result = changeStarBean(pageBean);

        return result;
    }

    //选择做项目的工作室
    @RequestMapping(value = "/selectStudio",method = RequestMethod.POST)
    @ResponseBody
    public Response selectStudio(@RequestParam Integer projectid,
                                 @RequestParam Integer studioid,
                                 @RequestParam String token){
        PjInformation project = pjInformationService.selectbyid(projectid);
        project.setBid(1);
        project.setStudioid(studioid);
        pjInformationService.updateinformation(project);

        return new LoginResponse(token);

    }

    //显示支付金额
    @RequestMapping(value = "/paynum",method = RequestMethod.POST)
    @ResponseBody
    public UserResponse<Double> paynest(@RequestParam Integer id,
                          @RequestParam String token){


        PjInformation project = pjInformationService.selectbyid(id);

        Double money = project.getMoney();

        Double child = money * proportion;

        return new UserResponse<>(token,child);

    }

    //支付定金


    //支付费用


    private Integer getUserid(HttpServletRequest request){
        User user = (User)request.getAttribute("user");
        return user.getId();
    }

    PageBean<StartStudio> changeStarBean(PageBean<StudioApply> pageBean){
        List<StudioApply> items = pageBean.getItems();
        List<StartStudio> list=new ArrayList<>();
        for(StudioApply apply:items){
            Integer countfinish = pjInformationService.countfinish(apply.getStudioid());
            StartStudio startStudio=new StartStudio(countfinish,apply);
            list.add(startStudio);
        }

        PageBean<StartStudio> result=new PageBean<>();
        result.setItems(list);
        result.setTotalPage(pageBean.getTotalPage());
        result.setTotalNum(pageBean.getTotalNum());
        return result;
    }
}
