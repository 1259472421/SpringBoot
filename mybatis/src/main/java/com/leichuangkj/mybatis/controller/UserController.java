package com.leichuangkj.mybatis.controller;

import com.leichuangkj.mybatis.common.ServerResponse;
import com.leichuangkj.mybatis.dao.po.User;
import com.leichuangkj.mybatis.service.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserImpl userImpl;

    @RequestMapping(value = "/findByName",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse findByName(@RequestBody User user){
        return userImpl.findByName(user.getName());
    }
}
