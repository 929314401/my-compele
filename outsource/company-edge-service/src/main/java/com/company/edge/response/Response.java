package com.company.edge.response;

import java.io.Serializable;

public class Response implements Serializable {

    public static final Response USER_OR_PASSWORD_ERR=new Response("1001","userid or password fail");

    public static final Response USERID_IS_EXIST=new Response("1002","userid has already exist");

    public static final Response MOBILE_SEND_ERR=new Response("1003","mobileCode can't send");

    public static final Response EMAIL_SEND_ERR=new Response("1004","emailCode can't send");

    public static final Response EMAIL_AND_MOBILE_NULL=new Response("1005","email and mobile is null");

    public static final Response VERIFYCODE_ERR=new Response("1006","verifyCode is err");
    private String code;
    private String message;

    public Response() {
        this("0","success");
    }

    public Response(String code, String message) {

        this.code = code;
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {

        return code;
    }

    public String getMessage() {
        return message;
    }
    public static Response exception(Exception e){
        return new Response("9999",e.getMessage());
    }
}
