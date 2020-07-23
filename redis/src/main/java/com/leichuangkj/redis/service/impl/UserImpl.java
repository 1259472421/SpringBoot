package com.leichuangkj.redis.service.impl;

import com.leichuangkj.redis.common.ServerResponse;
import com.leichuangkj.redis.dao.mapper.UserMapper;
import com.leichuangkj.redis.dao.po.User;
import com.leichuangkj.redis.service.IUser;
import com.leichuangkj.redis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements IUser {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse findByName(String name) {
        User user = (User) RedisUtil.get(this.redisTemplate, "user_" + name);
        if(user == null) {
            User userMySQL = userMapper.findByName(name);
            if(userMySQL == null){
                return ServerResponse.createByErrorMessage("没有查询到用户");
            }
            RedisUtil.set(this.redisTemplate, "user_" + name, userMySQL);
            return ServerResponse.createBySuccess(userMySQL);
        }
        return ServerResponse.createBySuccess(user);
    }
}
