package com.user.dubbo.service;

import com.user.dubbo.dto.CompanyDTO;
import com.user.dubbo.dto.UserCompany;

public interface CompanyService {
    void registerCompany(UserCompany userCompany);
    void updateCompany(UserCompany userCompany);
    UserCompany selectByuserid(Integer id);
    CompanyDTO selectByid(Integer id);

}
