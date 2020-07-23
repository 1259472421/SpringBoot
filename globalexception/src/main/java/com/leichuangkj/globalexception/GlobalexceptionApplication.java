package com.leichuangkj.globalexception;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.leichuangkj.globalexception.dao.mapper")
@SpringBootApplication
public class GlobalexceptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobalexceptionApplication.class, args);
	}

}
