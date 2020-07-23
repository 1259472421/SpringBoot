package com.leichuangkj.thymeleaf.service.impl;

import com.leichuangkj.thymeleaf.dao.mapper.UserMapper;
import com.leichuangkj.thymeleaf.dao.po.User;
import com.leichuangkj.thymeleaf.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserImpl implements IUser {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findAll() {
        List<User> userList = userMapper.findAll();
        return userList;
    }
}
