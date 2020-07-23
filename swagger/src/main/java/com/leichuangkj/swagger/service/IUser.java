package com.leichuangkj.swagger.service;


import com.leichuangkj.swagger.common.ServerResponse;

public interface IUser {
    ServerResponse findByName(String name);
}
