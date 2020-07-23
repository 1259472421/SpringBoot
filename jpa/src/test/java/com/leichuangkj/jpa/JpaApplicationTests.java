package com.leichuangkj.jpa;

import com.leichuangkj.jpa.dao.po.User;
import com.leichuangkj.jpa.service.impl.UserImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class JpaApplicationTests {

	@Resource
	private UserImpl userImpl;

	@Test
	void testFindByName(){
		List<User> userList =  userImpl.findByName("steven");
		System.out.println("findByName() :" + userList.size());
	}

	@Test
	void testFindByNameLike(){
		List<User> userList =  userImpl.findByNameLike("steven");
		System.out.println("testFindByNameLike() :" + userList.size());
	}

	@Test
	void testFindAll(){
		List<User> userList =  userImpl.findAll();
		System.out.println("findAll() :" + userList.size());
	}

	@Test
	void testFindAllByPage(){
		PageRequest pageRequest = PageRequest.of(0,10);
		Page<User> userList =  userImpl.findAll(pageRequest);
		System.out.println("page findAll():" + userList.getTotalPages() + "/" + userList.getSize());
	}
}
