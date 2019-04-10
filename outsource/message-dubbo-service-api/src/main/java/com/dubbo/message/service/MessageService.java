package com.dubbo.message.service;

public interface MessageService {
    public boolean sendEmailMessage(String email,String message,String subject);
    public boolean sendMobileMessage(String mobile,String message);
}
