package com.leichuangkj.activemq;

import com.leichuangkj.activemq.dao.po.Mood;
import com.leichuangkj.activemq.service.impl.MoodImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ActivemqApplicationTests {

	@Autowired
	MoodImpl moodImpl;

	@Test
	void contextLoads() {
		Mood mood = new Mood();
		mood.setId(1);
		mood.setUserId("21026");
		mood.setContent("雷创科技壹药库");
		mood.setPublishTime(new Date());
		String msg = moodImpl.asynSave(mood);
		System.out.println("发表说说:" + msg);
	}

}
