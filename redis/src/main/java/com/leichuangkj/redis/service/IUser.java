package com.leichuangkj.redis.service;


import com.leichuangkj.redis.common.ServerResponse;

public interface IUser {
    ServerResponse findByName(String name);
}
