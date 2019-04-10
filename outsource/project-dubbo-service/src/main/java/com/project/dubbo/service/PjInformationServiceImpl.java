package com.project.dubbo.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.dubbo.dto.PageBean;
import com.project.dubbo.dto.PjInformation;
import com.project.dubbo.dto.PjInformationExample;
import com.project.dubbo.mapper.PjInformationMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PjInformationServiceImpl implements  PjInformationService{


    @Autowired
    private PjInformationMapper pjInformationMapper;

    @Override
    public PageBean<PjInformation> selectByworkId(Integer integer,Integer page,Integer rows) {

        PageHelper.startPage(page,rows);
        PjInformationExample example=new PjInformationExample();
        PjInformationExample.Criteria criteria =
                example.createCriteria();
        criteria.andCompanyidEqualTo(integer);
        List<PjInformation> pjInformations = pjInformationMapper.selectByExample(example);

        PageInfo<PjInformation> pageInfo=new PageInfo<>(pjInformations);
        int total =(int) pageInfo.getTotal();
        PageBean<PjInformation> result=new PageBean<>(page,rows,total);
        result.setItems(pjInformations);
        result.setTotalPage(pageInfo.getPages());
        return result;
    }

    @Override
    public PageBean<PjInformation> selectBystudioId(Integer integer,Integer page,Integer rows) {
        PageHelper.startPage(page,rows);
        PjInformationExample example=new PjInformationExample();
        PjInformationExample.Criteria criteria = example.createCriteria();
        criteria.andStudioidEqualTo(integer);
        List<PjInformation> pjInformations = pjInformationMapper.selectByExample(example);
        PageInfo<PjInformation> pageInfo=new PageInfo<>(pjInformations);
        int total =(int) pageInfo.getTotal();
        PageBean<PjInformation> pageBean=new PageBean<>(page,rows,total);
        pageBean.setItems(pjInformations);
        pageBean.setTotalPage(pageInfo.getPages());

        return pageBean;
    }

    @Override
    public PjInformation selectbyid(Integer integer) {
        return pjInformationMapper.selectByPrimaryKey(integer);
    }

    @Override
    public Integer countfinish(Integer studioid) {
        PjInformationExample example=new PjInformationExample();
        PjInformationExample.Criteria criteria = example.createCriteria();
        criteria.andStudioidEqualTo(studioid);
        criteria.andBidEqualTo(3);
        return  pjInformationMapper.countByExample(example);


    }

    @Override
    public void updateinformation(PjInformation pjInformation) {
        pjInformationMapper.updateByPrimaryKey(pjInformation);
    }

    @Override
    public void registerProject(PjInformation pjInformation) {
        System.out.println(
                "插入数据"
        );
        pjInformationMapper.insert(pjInformation);
        System.out.println("成功");
    }

    @Override
    public void removeinByid(Integer integer) {
        pjInformationMapper.deleteByPrimaryKey(integer);
    }


}
