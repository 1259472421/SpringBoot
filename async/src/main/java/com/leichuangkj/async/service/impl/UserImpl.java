package com.leichuangkj.async.service.impl;

import com.leichuangkj.async.dao.mapper.UserMapper;
import com.leichuangkj.async.dao.po.User;
import com.leichuangkj.async.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

@Service
public class UserImpl implements IUser {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findAllSync() {
        try {
            System.out.println("开始做任务");
            long start = System.currentTimeMillis();
            List<User> userList = userMapper.findAll();
            long end = System.currentTimeMillis();
            System.out.println("完成任务，耗时:" + (end - start)+"毫秒");
            return userList;
        }catch (Exception e){
            return Collections.emptyList();
        }
    }

    @Async
    @Override
    public Future<List<User>> findAllAsync() {
        try {
            System.out.println("开始做任务");
            long start = System.currentTimeMillis();
            List<User> userList = userMapper.findAll();
            long end = System.currentTimeMillis();
            System.out.println("完成任务，耗时:" + (end - start)+"毫秒");
            return new AsyncResult<>(userList);
        }catch (Exception e){
            return new AsyncResult<>(null);
        }
    }
}
