package com.studio.work.dubbo.service;

import com.studio.work.dubbo.dto.WorkStudio;

public interface StudioWorkService {
    void registerStudioWork(WorkStudio workStudio);
    WorkStudio selectStudioByPid(Integer pid);
    void updateStudio(WorkStudio workStudio);
    WorkStudio selectStudioById(Integer id);

}
