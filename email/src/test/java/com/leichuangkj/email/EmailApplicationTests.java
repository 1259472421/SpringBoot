package com.leichuangkj.email;

import com.leichuangkj.email.service.impl.EmailImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EmailApplicationTests {
	@Autowired
	EmailImpl emailImpl;

	@Test
	void contextLoads() {
		List<String> toUsers = new ArrayList<>();
		toUsers.add("1259472421@qq.com");
		emailImpl.sendEmail("这是一封测试邮件", "百度一下，你就知道！",toUsers);
	}

}
