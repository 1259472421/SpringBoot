package com.leichuangkj.redis.dao.mapper;

import com.leichuangkj.redis.dao.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User findByName(String id);
}
