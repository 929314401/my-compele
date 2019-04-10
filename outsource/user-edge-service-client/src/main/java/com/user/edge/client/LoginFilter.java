package com.user.edge.client;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.user.dubbo.dto.User;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
public abstract class
LoginFilter implements Filter {
    //Guava Cache是全内存的本地缓存实现
    private static Cache<String,User> cache =
            CacheBuilder.newBuilder().maximumSize(10000)
                    .expireAfterWrite(3,TimeUnit.MINUTES).build();
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;


        response.setHeader("Access-Control-Allow-Origin", "*");
        String token = request.getParameter("token");
        //如果请求的token是空的，就找cookie的token所对应的token
        if(StringUtils.isBlank(token)){
            Cookie[] cookies=request.getCookies();
            if(cookies!=null){
                for (Cookie c:cookies){
                    if (c.getName().equals("token")){
                        token=c.getValue();
                    }
                }
            }
        }
        User userDTO=null;
        if(StringUtils.isNotBlank(token)) {
            userDTO = cache.getIfPresent(token);
            if (userDTO == null) {
                //获取redis里面的token
                userDTO = requestUserInfo(token);
                if (userDTO!=null) {
                    cache.put(token, userDTO);
                }
            }
        }
        if(userDTO==null){
            response.sendRedirect("http://192.168.56.1:8081/user/login");
            return;
        }


        login(request,response,userDTO);

        filterChain.doFilter(request,response);
    }

    protected abstract void login(HttpServletRequest request, HttpServletResponse response, User userDTO);

    private User requestUserInfo(String token) {
        //获取redis里面的token的UserDTO对象
        String url="http://192.168.56.1:8081/user/authentication";
        HttpClient client=new DefaultHttpClient();
        HttpPost post=new HttpPost(url);
        InputStream inputStream=null;
        post.addHeader("token",token);
        try {
            HttpResponse response= client.execute(post);
            if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
                throw new RuntimeException("request user info failed! StatusLine:"+response.getStatusLine().getStatusCode());
            }
            //转换成对象并获取Content
            inputStream=response.getEntity().getContent();
            byte[] temp=new byte[1024];
            StringBuilder sb=new StringBuilder();
            int len;
            while ((len=inputStream.read(temp))>0){
                sb.append(new String(temp,0,len));
            }
            User userDTO = new ObjectMapper().readValue(sb.toString(),User.class);
            return userDTO;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
        return null;
    }

    public void destroy() {

    }
}
