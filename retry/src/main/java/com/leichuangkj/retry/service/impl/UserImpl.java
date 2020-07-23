package com.leichuangkj.retry.service.impl;

import com.leichuangkj.retry.dao.mapper.UserMapper;
import com.leichuangkj.retry.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;


@Service
public class UserImpl implements IUser {
    @Autowired
    UserMapper userMapper;

    @Override
    @Retryable(value = {Exception.class},maxAttempts = 5,backoff = @Backoff(delay = 5000,multiplier = 2))
    public void findByName(String name) throws Exception {
        System.out.println("findByName方法调用失败，进行重试！");
        throw new Exception();
    }
}
