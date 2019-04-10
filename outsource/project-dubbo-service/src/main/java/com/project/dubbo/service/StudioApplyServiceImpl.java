package com.project.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.dubbo.dto.PageBean;
import com.project.dubbo.dto.PjInformation;
import com.project.dubbo.dto.StudioApply;
import com.project.dubbo.dto.StudioApplyExample;
import com.project.dubbo.mapper.StudioApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class StudioApplyServiceImpl implements  StudioApplyService {
    @Autowired
    private StudioApplyMapper studioApplyMapper;
    @Override
    public PageBean<StudioApply> selectByProjectId(Integer id,Integer page,Integer rows) {
        PageHelper.startPage(page,rows);
        StudioApplyExample example=new StudioApplyExample();
        StudioApplyExample.Criteria criteria = example.createCriteria();
        criteria.andProjectidEqualTo(id);
        List<StudioApply> studioApplies = studioApplyMapper.selectByExample(example);

        PageInfo<StudioApply> pageInfo=new PageInfo<>(studioApplies);
        int total =(int) pageInfo.getTotal();
        PageBean<StudioApply> pageBean=new PageBean<>(page,rows,total);
        pageBean.setItems(studioApplies);
        pageBean.setTotalPage(pageInfo.getPages());
        return pageBean;

    }

    @Override
    public PageBean<StudioApply> selectByStudioId(Integer id,Integer page,Integer rows) {
        PageHelper.startPage(page,rows);
        StudioApplyExample example=new StudioApplyExample();
        StudioApplyExample.Criteria criteria = example.createCriteria();
        criteria.andStudioidEqualTo(id);
        List<StudioApply> studioApplies = studioApplyMapper.selectByExample(example);
        PageInfo<StudioApply> pageInfo=new PageInfo<>(studioApplies);
        int total =(int) pageInfo.getTotal();
        PageBean<StudioApply> pageBean=new PageBean<>(page,rows,total);
        pageBean.setItems(studioApplies);
        pageBean.setTotalPage(pageInfo.getPages());
        return pageBean;
    }

    @Override
    public void insertApply(StudioApply studioApply) {
        studioApplyMapper.insert(studioApply);
    }

    List<StudioApply> pageStudio(List<StudioApply> list, Integer page, Integer rows){

        int size =list.size();//总数
        PageBean<StudioApply> pageInfo=new PageBean<>(page,rows,size);
        pageInfo.setItems(list);
        return pageInfo.getItems();
    }
}

