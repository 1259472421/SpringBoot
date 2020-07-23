package com.leichuangkj.globalexception.service;

import com.leichuangkj.globalexception.common.ServerResponse;

public interface IUser {
    ServerResponse findByName(String name);
}
