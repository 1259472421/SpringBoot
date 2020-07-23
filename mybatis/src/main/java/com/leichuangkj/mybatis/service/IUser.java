package com.leichuangkj.mybatis.service;


import com.leichuangkj.mybatis.common.ServerResponse;

public interface IUser {
    ServerResponse findByName(String name);
}
