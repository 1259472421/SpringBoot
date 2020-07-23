package com.leichuangkj.mockito;

import com.leichuangkj.mockito.dao.po.User;
import com.leichuangkj.mockito.service.impl.UserImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class MockitoApplicationTests {

	@Test
	void contextLoads() {
		UserImpl userImpl = mock(UserImpl.class);
		User user = userImpl.findByName("steven");
		System.out.println(user.getEmail());
	}

}
