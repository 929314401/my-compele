package com.studio.work.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.studio.work.dubbo.dto.WorkStudio;
import com.studio.work.dubbo.dto.WorkStudioExample;
import com.studio.work.dubbo.mapper.WorkStudioMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class StudioWorkServiceImpl implements StudioWorkService {
    @Autowired
    private WorkStudioMapper workStudioMapper;
    @Override
    public void registerStudioWork(WorkStudio workStudio) {
        workStudioMapper.insert(workStudio);
    }

    @Override
    public WorkStudio selectStudioByPid(Integer pid) {
        WorkStudioExample example=new WorkStudioExample();
        WorkStudioExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(pid);
        List<WorkStudio> workStudios = workStudioMapper.selectByExample(example);
        return workStudios.get(0);

    }

    @Override
    public void  updateStudio(WorkStudio workStudio) {
        workStudioMapper.updateByPrimaryKey(workStudio);
    }

    @Override
    public WorkStudio selectStudioById(Integer id) {
        return workStudioMapper.selectByPrimaryKey(id);
    }


}
