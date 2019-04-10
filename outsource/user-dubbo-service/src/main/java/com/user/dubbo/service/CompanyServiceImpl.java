package com.user.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.user.dubbo.dto.CompanyDTO;
import com.user.dubbo.dto.UserCompany;
import com.user.dubbo.mapper.AllUserMapper;
import com.user.dubbo.mapper.UserCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CompanyServiceImpl implements CompanyService {


    @Autowired
    private UserCompanyMapper userCompanyMapper;
    @Autowired
    private AllUserMapper allUserMapper;
    @Override
    public void registerCompany(UserCompany userCompany) {
        userCompanyMapper.insert(userCompany);
    }

    @Override
    public void updateCompany(UserCompany userCompany) {
        userCompanyMapper.updateByPrimaryKey(userCompany);
    }

    @Override
    public UserCompany selectByuserid(Integer id) {
        return userCompanyMapper.selectByPrimaryKey(id);

    }

    @Override
    public CompanyDTO selectByid(Integer id) {
        return allUserMapper.selectCompanyDTOByid(id);
    }
}