package com.edge.work.studio.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.edge.work.studio.result.Result;
import com.studio.work.dubbo.dto.*;
import com.studio.work.dubbo.service.PictureStudioService;
import com.studio.work.dubbo.service.StudioWorkService;
import com.studio.work.dubbo.service.WorkSubjectService;
import com.user.dubbo.dto.User;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

@RestController
@RequestMapping("/studio")
public class StudioWorkController {

    @Reference
    private PictureStudioService pictureStudioService;

    @Reference
    private StudioWorkService studioWorkService;

    @Reference
    private WorkSubjectService workSubjectService;

    //通过id查询工作室--当把所有工作室列出来时可以拿到他的id号
    @RequestMapping(value = "/selectone/{id}",method = RequestMethod.GET)
    @ResponseBody
    public StudioAll selectoneId(@PathVariable("id") Integer id){

        StudioAll studioAll=new StudioAll();
        WorkStudio workStudio = studioWorkService.selectStudioById(id);
        List<PictrueStudio> pictrueStudios =
                pictureStudioService.selectByPid(id);
        studioAll.setWorkStudio(workStudio);
        if(pictrueStudios!=null){
            List<String> im=new LinkedList<>();
            for (PictrueStudio s:pictrueStudios){
                String image = s.getImage();
                im.add(image);
            }

            studioAll.setImages(im);
        }

        return studioAll;

    }

    //展示该账号工作室信息
    @RequestMapping(value = "/selectown",method = RequestMethod.POST)
    @ResponseBody
    public WorkStudio selectown(HttpServletRequest request){
        User user=(User)request.getAttribute("user");
        WorkStudio workStudio = studioWorkService.selectStudioByPid(user.getId());
        return workStudio;

    }


    //更新工作室基本信息
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestParam("workname") String workname,
                         @RequestParam("desc") String desc,
                         @RequestParam("start") String start,
                         @RequestParam("ip") String ip,
                         @RequestParam("address") String address,
                         @RequestParam("toux") String toux,
                         HttpServletRequest request ) throws ParseException {
        User user =(User) request.getAttribute("user");
        Integer id = user.getId();
        WorkStudio workStudio = studioWorkService.selectStudioByPid(id);
        if(StringUtils.isNotBlank(workname))
            workStudio.setWorkName(workname);

        if(StringUtils.isNotBlank(desc))
            workStudio.setDescb(desc);

        if(StringUtils.isNotBlank(start)){
            Date date = StringChangeDate(start);
            workStudio.setStart(date);
        }

        if(StringUtils.isNotBlank(ip))
            workStudio.setIp(ip);

        if(StringUtils.isNotBlank(address))
            workStudio.setAddress(address);

        if(StringUtils.isNotBlank(toux))
            workStudio.setToux(toux);

        studioWorkService.updateStudio(workStudio);
        return new Result();

    }

    @RequestMapping(value="/uploadimg", method = RequestMethod.POST)
    @ResponseBody
    public  String uploadImg(@RequestParam("file") MultipartFile file,
                                          HttpServletRequest request) {

        String contentType = file.getContentType();   //图片文件类型
        String fileName = file.getOriginalFilename();  //图片名字

        //文件存放路径
        String filePath = "C:\\Users\\Administrator\\Desktop\\vue-manage-system-master\\static\\uploadimg\\";

        //调用文件处理类FileUtil，处理文件，将文件写入指定位置
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }

        // 返回图片的存放路径
        return filePath;
    }

    //展示该公司做过的项目列表
    @RequestMapping(value = "/subjectls",method = RequestMethod.POST)
    @ResponseBody
    public PageBean<WorkSubject> subjectlis(@RequestParam Integer pid,
                                            @RequestParam(required = false) Integer page,
                                            @RequestParam(required = false) Integer rows){
        if(page == null){
            page = 1;   //设置默认当前页
        }
        if(page <= 0){
            page = 1;
        }
        if(rows==null)
            rows=6;
        PageBean<WorkSubject> workSubjectPageBean = workSubjectService.selectByPid(pid, page, rows);
        return workSubjectPageBean;
    }



    //删除一个项目
    @RequestMapping(value = "/rmsubject",method = RequestMethod.POST)
    @ResponseBody
    public Result rmsubject(@RequestParam Integer id){
        workSubjectService.removeSubjectById(id);
        return new Result();
    }

    //工作室接项目后有三个状态，1-接项目，2-完成项目，3-完成交付

    //工作室接项目
    @RequestMapping(value = "/addsubject",method = RequestMethod.POST)
    @ResponseBody
    public Result addsubjcet(@RequestParam(required = true)Integer workid,
                             @RequestParam(required = false) String desc,
                             @RequestParam(required = false) String imag){

        WorkSubject subject=new WorkSubject();
        if(StringUtils.isNotBlank(desc))
            subject.setDesct(desc);
        if(StringUtils.isNotBlank(imag))
            subject.setImage(imag);
        subject.setWorkId(workid);
        Date now=new Date();
        subject.setStarttime(now);
        return new Result();
    }

    //更新项目状态
    @RequestMapping(value ="/finsubjcet",method = RequestMethod.POST)
    @ResponseBody
    public Result finsubject(Integer id,Integer state){
        WorkSubject subject = workSubjectService.selectById(id);
        subject.setStar(state);
        workSubjectService.updateSubject(subject);
        return new Result();
    }


    public static Date StringChangeDate(String date) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date strtodate = formatter.parse(date);
       return strtodate;
    }

}
