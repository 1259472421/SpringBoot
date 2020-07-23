package com.leichuangkj.jpa.service.impl;

import com.leichuangkj.jpa.dao.po.User;
import com.leichuangkj.jpa.dao.repository.UserRepository;
import com.leichuangkj.jpa.service.IUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserImpl implements IUser {
    @Resource
    UserRepository userRepository;

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> findByNameLike(String name) {
        return userRepository.findByNameLike(name);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
