package com.leichuangkj.test.dao.mapper;

import com.leichuangkj.test.dao.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User findByName(String id);
}
