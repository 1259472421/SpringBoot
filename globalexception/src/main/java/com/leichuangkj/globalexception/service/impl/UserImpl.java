package com.leichuangkj.globalexception.service.impl;

import com.leichuangkj.globalexception.common.ServerResponse;
import com.leichuangkj.globalexception.dao.mapper.UserMapper;
import com.leichuangkj.globalexception.dao.po.User;
import com.leichuangkj.globalexception.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserImpl implements IUser {
    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse findByName(String name) {
        User user = userMapper.findByName(name);
        System.out.println(user.getName());
        if(user == null){
            return ServerResponse.createByErrorMessage("没有查询到用户");
        }
        return ServerResponse.createBySuccess(user);
    }
}
