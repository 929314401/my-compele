package com.studio.edge.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.project.dubbo.service.StudioApplyService;
import com.user.dubbo.dto.StudioDTO;
import com.user.dubbo.dto.User;
import com.user.dubbo.service.StudioService;
import com.user.dubbo.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/studio")
public class StudioController {
    @Reference
    private StudioApplyService studioApplyService;

    @Reference
    private StudioService studioService;

    //查看账号信息
    @RequestMapping("/Own")
    @ResponseBody
    public StudioDTO Own(HttpServletRequest request){
        Integer userid = getUserid(request);
        StudioDTO studioDTO = studioService.selectByid(userid);
        return studioDTO;
    }
    private Integer getUserid(HttpServletRequest request){
        User user = (User)request.getAttribute("user");
        return user.getId();
    }

}

