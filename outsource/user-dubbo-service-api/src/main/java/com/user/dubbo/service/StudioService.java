package com.user.dubbo.service;

import com.user.dubbo.dto.CompanyDTO;
import com.user.dubbo.dto.StudioDTO;
import com.user.dubbo.dto.UserCompany;
import com.user.dubbo.dto.UserStudio;

public interface StudioService {
    void registerStudio(UserStudio userStudio);
    void updateStudio(UserStudio userStudio);
    UserStudio selectByuserid(Integer id);
    StudioDTO selectByid(Integer id);
}
