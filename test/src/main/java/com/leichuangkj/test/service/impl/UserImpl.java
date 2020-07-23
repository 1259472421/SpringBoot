package com.leichuangkj.test.service.impl;

import com.leichuangkj.test.dao.mapper.UserMapper;
import com.leichuangkj.test.dao.po.User;
import com.leichuangkj.test.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements IUser {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }
}
