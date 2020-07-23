package com.leichuangkj.retry.controller;

import com.leichuangkj.retry.dao.po.User;
import com.leichuangkj.retry.service.impl.UserImpl;
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
    public void findByName(@RequestBody User user){
        try{
         userImpl.findByName(user.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
