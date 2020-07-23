package com.leichuangkj.jpa.service;

import com.leichuangkj.jpa.dao.po.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUser {
    List<User> findByName(String name);

    List<User> findByNameLike(String name);

    List<User> findAll();

    Page<User> findAll(Pageable pageable);
}
