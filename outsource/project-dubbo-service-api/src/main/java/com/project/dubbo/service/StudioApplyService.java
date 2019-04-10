package com.project.dubbo.service;

import com.project.dubbo.dto.PageBean;
import com.project.dubbo.dto.StudioApply;


public interface StudioApplyService {
    PageBean<StudioApply> selectByProjectId(Integer id,Integer page,Integer rows);
    PageBean<StudioApply> selectByStudioId(Integer id, Integer page, Integer rows);
    void insertApply(StudioApply apply);
}
