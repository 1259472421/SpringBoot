package com.leichuangkj.mockito.service.impl;

import com.leichuangkj.mockito.dao.mapper.UserMapper;
import com.leichuangkj.mockito.dao.po.User;
import com.leichuangkj.mockito.service.IUser;
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
