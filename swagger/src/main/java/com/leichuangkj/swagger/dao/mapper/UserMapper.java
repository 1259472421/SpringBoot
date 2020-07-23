package com.leichuangkj.swagger.dao.mapper;

import com.leichuangkj.swagger.dao.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User findByName(String id);
}
