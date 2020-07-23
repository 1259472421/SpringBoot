package com.leichuangkj.activemq.dao.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mood implements Serializable{
    private Integer id;

    private String userId;

    private String content;

    private Date publishTime;
}