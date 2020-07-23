package com.leichuangkj.endpoint.service.impl;

import com.leichuangkj.endpoint.dao.mapper.UserMapper;
import com.leichuangkj.endpoint.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements IUser {
    @Autowired
    UserMapper userMapper;

    @Override
    public Integer getTotalNum() {
        return userMapper.getTotalNum();
    }
}
