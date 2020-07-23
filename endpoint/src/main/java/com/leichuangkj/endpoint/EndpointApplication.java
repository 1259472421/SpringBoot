package com.leichuangkj.endpoint;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.leichuangkj.endpoint.dao.mapper")
@SpringBootApplication
public class EndpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(EndpointApplication.class, args);
	}

}
