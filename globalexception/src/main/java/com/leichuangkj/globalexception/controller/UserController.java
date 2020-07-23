package com.leichuangkj.globalexception.controller;

import com.leichuangkj.globalexception.common.ServerResponse;
import com.leichuangkj.globalexception.dao.po.User;
import com.leichuangkj.globalexception.service.impl.UserImpl;
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
        int rs = 1/0;
        return userImpl.findByName(user.getName());
    }
}
