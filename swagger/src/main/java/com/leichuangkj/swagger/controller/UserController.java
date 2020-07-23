package com.leichuangkj.swagger.controller;

import com.leichuangkj.swagger.common.ServerResponse;
import com.leichuangkj.swagger.dao.po.User;
import com.leichuangkj.swagger.service.impl.UserImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value="findByName", notes="根据用户姓名获取用户详情")
    @ApiImplicitParam(name = "name", value = "用户姓名", required = true, dataType = "String")
    @RequestMapping(value = "/findByName",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse findByName(@RequestBody User user){
        return userImpl.findByName(user.getName());
    }
}
