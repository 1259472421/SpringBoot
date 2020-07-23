package com.leichuangkj.logback;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogbackApplicationTests {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(LogbackApplicationTests.class);

	@Test
	void contextLoads() {
		log.debug("log level:debug");
		log.info("log level:info");
		log.warn("log level:warn");
		log.error("log level:error");
	}

}
