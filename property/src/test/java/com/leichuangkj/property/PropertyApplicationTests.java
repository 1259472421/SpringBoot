package com.leichuangkj.property;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class PropertyApplicationTests {

	@Resource
	private Properties properties;

	@Test
	void contextLoads() {
		System.out.println("name:"+properties.getName());
		System.out.println("email:"+properties.getEmail());
	}

}
