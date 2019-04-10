package com.user.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.user.dubbo.dto.StudioDTO;
import com.user.dubbo.dto.UserStudio;
import com.user.dubbo.mapper.AllUserMapper;
import com.user.dubbo.mapper.UserStudioMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StudioServiceImpl implements StudioService {

    @Autowired
    private UserStudioMapper userStudioMapper;

    @Autowired
    private AllUserMapper allUserMapper;

    @Override
    public void registerStudio(UserStudio userStudio) {
        userStudioMapper.insert(userStudio);
    }

    @Override
    public void updateStudio(UserStudio userStudio) {
        userStudioMapper.updateByPrimaryKey(userStudio);
    }

    @Override
    public UserStudio selectByuserid(Integer id) {
        return userStudioMapper.selectByPrimaryKey(id);
    }

    @Override
    public StudioDTO selectByid(Integer id) {

        return allUserMapper.selectStudioDtoByid(id);
    }
}
