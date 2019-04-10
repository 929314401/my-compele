package com.dubbo.message.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.message.MailAuthenticator;
import org.springframework.beans.factory.annotation.Value;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

@Service
public class MessageServiceImp implements MessageService {

    /*
    send 发件邮箱
    authCode authCode码
    email 接收邮箱
    messgae 内容
    subject 主题
     */
    @Value("${email.sender}")
    private String send;

    @Value("${email.authCode}")
    private String authCode;

    @Override
    public boolean sendEmailMessage(String email, String message,String subject) {
        Properties props=System.getProperties();
        props.put("mail.smtp.host", "smtp.163.com");
        props.put("mail.smtp.auth", "true");
        MailAuthenticator auth=new MailAuthenticator();
        //发送邮箱的账号和
        auth.USERNAME=send;
        auth.PASSWORD=authCode;
        Session session=Session.getInstance(props,auth);
        session.setDebug(true);
        try {
            MimeMessage me=new MimeMessage(session);
            me.setFrom(new InternetAddress(send));
            if(!email.trim().equals("")) {
                me.addRecipient(Message.RecipientType.TO,
                        new InternetAddress(email.trim()));
            }else{
                return false;
            }
            me.setSubject(subject);
            MimeBodyPart mbp=new MimeBodyPart();// 正文
            mbp.setContent(message, "text/html;charset=utf-8");
            Multipart mp=new MimeMultipart();// 整个邮件：正文+附件
            mp.addBodyPart(mbp);
            me.setContent(mp);
            me.setSentDate(new Date());
            me.saveChanges();
            Transport tran=session.getTransport("smtp");
            tran.send(me);
            System.out.println(me.toString());
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean sendMobileMessage(String mobile, String message) {
        System.out.println(message);
        return true;
    }
}