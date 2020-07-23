package com.leichuangkj.profiles.service;

import com.leichuangkj.profiles.common.ServerResponse;

public interface IUser {
    ServerResponse findByName(String name);
}
