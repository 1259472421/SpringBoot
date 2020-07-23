package com.leichuangkj.async;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@MapperScan(basePackages = "com.leichuangkj.async.dao.mapper")
@SpringBootApplication
@EnableAsync(proxyTargetClass = true)
public class AsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncApplication.class, args);
	}

}
