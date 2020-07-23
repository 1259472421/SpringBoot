package com.leichuangkj.profiles.service.impl;

import com.leichuangkj.profiles.common.ServerResponse;
import com.leichuangkj.profiles.dao.mapper.UserMapper;
import com.leichuangkj.profiles.dao.po.User;
import com.leichuangkj.profiles.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserImpl implements IUser {
    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse findByName(String name) {
        User user = userMapper.findByName(name);
        if(user == null){
            return ServerResponse.createByErrorMessage("没有查询到用户");
        }
        return ServerResponse.createBySuccess(user);
    }
}
