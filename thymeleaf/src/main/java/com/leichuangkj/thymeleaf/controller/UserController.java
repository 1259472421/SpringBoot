package com.leichuangkj.thymeleaf.controller;

import com.leichuangkj.thymeleaf.dao.po.User;
import com.leichuangkj.thymeleaf.service.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserImpl userImpl;

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public String findAll(Model model){
        List<User> userList = userImpl.findAll();
        model.addAttribute("users",userList);
        return "user";
    }
}
