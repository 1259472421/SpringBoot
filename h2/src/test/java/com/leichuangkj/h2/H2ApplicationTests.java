package com.leichuangkj.h2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.annotation.Resource;

@SpringBootTest
@TestPropertySource("classpath:application.properties")
class H2ApplicationTests {
	@Resource
	private UserRepository userRepository;

	/**
	 * @description SpringBoot集成H2单元测试，测试用户保存是否成功
	 * @author steven
	 * @date 2020-06-14
	 */
	@Test
	public void testSave() {
		User user = new User();
		user.setId(1);
		user.setName("steven");
		user.setEmail("125****421@qq.com");
		User rs = userRepository.save(user);
		Assertions.assertNotNull(rs);
	}

	/**
	 * @description SpringBoot集成H2单元测试，测试通过用户名查找用户
	 * @author steven
	 * @date 2020-06-14
	 */
	@Test
	public void testFindByName() {
		User user = userRepository.findByName("steven");
		Assertions.assertNotNull(user);
		Assertions.assertEquals(user.getEmail(),"125****421@qq.com");
	}
}
