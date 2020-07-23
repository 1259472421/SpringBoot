package com.leichuangkj.retry;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@MapperScan(basePackages = "com.leichuangkj.retry.dao.mapper")
@SpringBootApplication
@EnableRetry
public class RetryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetryApplication.class, args);
	}

}
