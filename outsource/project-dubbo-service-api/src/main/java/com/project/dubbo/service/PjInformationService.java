package com.project.dubbo.service;

import com.project.dubbo.dto.PageBean;
import com.project.dubbo.dto.PjInformation;

import java.util.List;

public interface PjInformationService {
    PageBean<PjInformation> selectByworkId(Integer workid, Integer page, Integer rows);
    PageBean<PjInformation> selectBystudioId(Integer studioid,Integer page,Integer rows);
    PjInformation selectbyid(Integer id);
    Integer countfinish(Integer studioid);
    void updateinformation(PjInformation information);
    void registerProject(PjInformation information);
    void removeinByid(Integer id);


}
