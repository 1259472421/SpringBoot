package com.leichuangkj.globalexception.dao.mapper;

import com.leichuangkj.globalexception.dao.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User findByName(String name);
}
