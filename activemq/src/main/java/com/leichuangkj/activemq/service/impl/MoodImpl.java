package com.leichuangkj.activemq.service.impl;

import com.leichuangkj.activemq.dao.mapper.MoodMapper;
import com.leichuangkj.activemq.dao.po.Mood;
import com.leichuangkj.activemq.producer.MoodProducer;
import com.leichuangkj.activemq.service.IMood;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

@Service
public class MoodImpl implements IMood{
    private static Destination destination = new ActiveMQQueue("steven.queue");

    @Autowired
    MoodProducer moodProducer;

    @Autowired
    MoodMapper moodMapper;

    @Override
    public void save(Mood mood) {
        moodMapper.insertSelective(mood);
    }

    @Override
    public String asynSave(Mood mood) {
        moodProducer.sendMessage(destination,mood);
        return "成功！";
    }
}
