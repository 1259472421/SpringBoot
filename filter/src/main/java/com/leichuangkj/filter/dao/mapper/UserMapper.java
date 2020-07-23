package com.leichuangkj.filter.dao.mapper;

import com.leichuangkj.filter.dao.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User findByName(String name);
}
