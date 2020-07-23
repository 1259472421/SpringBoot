package com.leichuangkj.mockito.dao.mapper;

import com.leichuangkj.mockito.dao.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User findByName(String id);
}
