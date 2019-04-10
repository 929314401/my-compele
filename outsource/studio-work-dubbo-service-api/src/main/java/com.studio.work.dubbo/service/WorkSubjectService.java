package com.studio.work.dubbo.service;

import com.studio.work.dubbo.dto.PageBean;
import com.studio.work.dubbo.dto.WorkSubject;

import java.util.List;

public interface WorkSubjectService {
    PageBean<WorkSubject> selectByPid(Integer pid, Integer page, Integer rows);
    void updateSubject(WorkSubject subject);
    void removeSubjectById(Integer id);
    WorkSubject selectById(Integer id);
}
