package com.leichuangkj.activemq.controller;

import com.leichuangkj.activemq.dao.po.Mood;
import com.leichuangkj.activemq.service.impl.MoodImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/mood")
public class MoodController {

    @Autowired
    MoodImpl moodImpl;

    @RequestMapping(value = "/saveMood",method = RequestMethod.GET)
    @ResponseBody
    public String saveMood(){
        Mood mood = new Mood();
        mood.setId(1);
        mood.setUserId("21026");
        mood.setContent("hello world!");
        mood.setPublishTime(new Date());
        String msg = moodImpl.asynSave(mood);
        return "发表说说:" + msg;
    }
}