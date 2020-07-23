package com.leichuangkj.email.service;

import java.util.List;

public interface IEmail {
    boolean sendEmail(String subject,String content,List<String> toUsers);
}
