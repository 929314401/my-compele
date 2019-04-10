package com.studio.edge.filter;

import com.user.dubbo.dto.User;
import com.user.edge.client.LoginFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudioFilter extends LoginFilter {
    @Override
    protected void login(HttpServletRequest request, HttpServletResponse response, User userDTO) {
        request.setAttribute("user",userDTO);
    }


}
