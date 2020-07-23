package com.leichuangkj.async.dao.mapper;

import com.leichuangkj.async.dao.po.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> findAll();
}
