package com.leichuangkj.jpa.dao.repository;

import com.leichuangkj.jpa.dao.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
    /**
     * @description 通过姓名查询
     * @param name
     * @return User
     * @author steven
     * @date 2020-06-16
     */
    List<User> findByName(String name);

    /**
     * @description 通过姓名like查询
     * @param name
     * @return User
     * @author steven
     * @date 2020-06-16
     */
    List<User> findByNameLike(String name);
}
