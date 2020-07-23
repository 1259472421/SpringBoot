package com.leichuangkj.profiles.dao.mapper;

import com.leichuangkj.profiles.dao.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User findByName(String name);
}
