package com.leichuangkj.async.service;


import com.leichuangkj.async.dao.po.User;

import java.util.List;
import java.util.concurrent.Future;

public interface IUser {
    List<User> findAllSync() ;

    Future<List<User>> findAllAsync();
}
