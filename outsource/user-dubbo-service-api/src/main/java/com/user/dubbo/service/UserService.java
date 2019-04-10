package com.user.dubbo.service;


import com.user.dubbo.dto.User;

import java.util.List;

public interface UserService {
    User selectById(Integer id);
    User selectByUid(String userid);
    List<User> listUnlikeUser(Integer state);
    void regiserUser(User user);

}
