package com.leichuangkj.mybatis.dao.mapper;

import com.leichuangkj.mybatis.dao.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User findByName(String id);
}
