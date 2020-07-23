package com.leichuangkj.activemq.service;

import com.leichuangkj.activemq.dao.po.Mood;

public interface IMood {
    void save(Mood mood);

    String asynSave(Mood mood);
}
