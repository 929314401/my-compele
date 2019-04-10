package com.user.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.user.dubbo.dto.User;
import com.user.dubbo.dto.UserExample;
import com.user.dubbo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User selectByUid(String userid) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<User> users = userMapper.selectByExample(example);
        int size = users.size();
        //System.out.println(size);
        User user=null;
        if (size>0)
            user = users.get(0);
        return user;
    }
    @Override
    public List<User> listUnlikeUser(Integer state) {
        UserExample example=new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo(state);
        return userMapper.selectByExample(example);
    }

    @Override
    public void regiserUser(User user) {
        userMapper.insert(user);
    }
}
