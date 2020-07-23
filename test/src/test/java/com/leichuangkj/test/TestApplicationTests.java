package com.leichuangkj.test;

import com.leichuangkj.test.dao.po.User;
import com.leichuangkj.test.service.impl.UserImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.jvm.hotspot.utilities.Assert;

import javax.annotation.Resource;

@SpringBootTest
class TestApplicationTests {

	@Resource
	UserImpl userImpl;

	@Test
	void contextLoads() {
		User user = userImpl.findByName("steven");

		//AssertJ断言
		Assertions.assertEquals("steven",user.getName());

		Assertions.assertEquals("125****421@qq.com",user.getEmail());
	}

}
