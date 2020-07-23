package com.leichuangkj.mockito;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.leichuangkj.mockito.dao.mapper")
@SpringBootApplication
public class MockitoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockitoApplication.class, args);
	}

}
