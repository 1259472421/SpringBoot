package com.leichuangkj.mockito.service;

import com.leichuangkj.mockito.dao.po.User;

public interface IUser {
    User findByName(String name);
}
