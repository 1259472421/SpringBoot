package com.leichuangkj.test.service;

import com.leichuangkj.test.dao.po.User;

public interface IUser {
    User findByName(String name);
}
