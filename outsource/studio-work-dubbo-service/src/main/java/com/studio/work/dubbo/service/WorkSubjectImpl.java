package com.studio.work.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.studio.work.dubbo.dto.PageBean;
import com.studio.work.dubbo.dto.WorkSubject;
import com.studio.work.dubbo.dto.WorkSubjectExample;
import com.studio.work.dubbo.mapper.WorkSubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
//
@Service
public class WorkSubjectImpl implements WorkSubjectService {
    @Autowired
    private WorkSubjectMapper workSubjectMapper;
    @Override

    public PageBean<WorkSubject> selectByPid(Integer pid,Integer page,Integer rows) {
        PageHelper.startPage(page,rows);


        WorkSubjectExample example=new WorkSubjectExample();
        WorkSubjectExample.Criteria criteria = example.createCriteria();
        criteria.andWorkIdEqualTo(pid);
        List<WorkSubject> workSubjects = workSubjectMapper.selectByExample(example);
        int size = workSubjects.size();//总数
        PageBean<WorkSubject> pageInfo=new PageBean<>(page,rows,size);
        pageInfo.setItems(workSubjects);
        return pageInfo;
    }

    @Override
    public void updateSubject(WorkSubject subject) {
        workSubjectMapper.updateByPrimaryKey(subject);

    }

    @Override
    public void removeSubjectById(Integer id) {
        workSubjectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public WorkSubject selectById(Integer id) {
        WorkSubject subject = workSubjectMapper.selectByPrimaryKey(id);
        return subject;
    }


}
