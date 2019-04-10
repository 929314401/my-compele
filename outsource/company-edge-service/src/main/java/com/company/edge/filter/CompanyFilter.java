package com.company.edge.filter;

import com.user.dubbo.dto.User;
import com.user.edge.client.LoginFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CompanyFilter extends LoginFilter {
    @Override
    protected void login(HttpServletRequest request, HttpServletResponse response, User userDTO) {
        request.setAttribute("user",userDTO);
    }


}
