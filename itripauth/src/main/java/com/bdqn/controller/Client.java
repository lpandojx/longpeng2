package com.bdqn.controller;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class Client {

    public static void SentSmail(String email,String code) throws Exception {
        Properties props = new Properties();
        //设置邮件地址
        props.put("mail.smtp.host", "smtp.126.com");
        //开启认证
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, null);
        Transport transport = session.getTransport();
        //用户名
        String user = "QQ3204902930@.126com";
        //授权码
        String password = "WVVMBTPZRGCVFZVB";
        transport.connect(user, password);
        //创建邮件消息
        MimeMessage msg = new MimeMessage(session);
        msg.setSentDate(new Date());
        //邮件发送人
        InternetAddress fromAddress = new InternetAddress(user, "邮件服务");
        msg.setFrom(fromAddress);
        //邮件接收人
        String to = "QQ3204902930@126.com";
        InternetAddress[] toAddress = new InternetAddress[]{new InternetAddress(to)};
        msg.setRecipients(Message.RecipientType.TO, toAddress);
        //邮件主题
        msg.setSubject("测试邮件发送", "UTF-8");
        //邮件内容和格式
        msg.setContent("验证码", "text/html;charset=UTF-8");
        msg.saveChanges();
        //发送
        transport.sendMessage(msg, msg.getAllRecipients());
    }


}
