package com.leichuangkj.activemq.consumer;

import com.leichuangkj.activemq.dao.po.Mood;
import com.leichuangkj.activemq.service.impl.MoodImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MoodConsumer {

    @Autowired
    MoodImpl moodImpl;

    @JmsListener(destination = "steven.queue")
    public void receiveQueue(Mood mood){
        moodImpl.save(mood);
    }
}
