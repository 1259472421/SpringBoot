package com.leichuangkj.retry.dao.mapper;

import com.leichuangkj.retry.dao.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User findByName(String name);
}
