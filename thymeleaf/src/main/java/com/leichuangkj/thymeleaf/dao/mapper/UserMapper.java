package com.leichuangkj.thymeleaf.dao.mapper;

import com.leichuangkj.thymeleaf.dao.po.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> findAll();
}
