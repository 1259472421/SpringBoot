package com.leichuangkj.filter.service;

import com.leichuangkj.filter.common.ServerResponse;

public interface IUser {
    ServerResponse findByName(String name);
}
