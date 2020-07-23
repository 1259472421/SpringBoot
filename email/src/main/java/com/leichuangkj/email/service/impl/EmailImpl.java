package com.leichuangkj.email.service.impl;

import com.leichuangkj.email.service.IEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class EmailImpl implements IEmail{
    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * @description 发送邮件
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param toUsers 收件人
     */
    @Override
    public boolean sendEmail(String subject,String content,List<String> toUsers) {
        try{
            if(toUsers == null || toUsers.size() <= 0 ) return Boolean.FALSE;
            for(String user: toUsers){
                MimeMessage mimeMessage = this.mailSender.createMimeMessage();
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                //邮件发送方
                message.setFrom(from);
                //邮件主题
                message.setSubject(subject);
                //邮件接收方
                message.setTo(user);
                //邮件内容
                message.setText(content);
                //发送邮件
                this.mailSender.send(mimeMessage);
            }
        }catch(Exception ex){
            System.out.println("邮件发送异常！");
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
