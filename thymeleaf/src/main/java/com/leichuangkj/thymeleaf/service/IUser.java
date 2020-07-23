package com.leichuangkj.thymeleaf.service;

import com.leichuangkj.thymeleaf.dao.po.User;

import java.util.List;

public interface IUser {
    List<User> findAll();
}
