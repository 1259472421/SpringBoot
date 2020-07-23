package com.leichuangkj.async.Controller;

import com.leichuangkj.async.dao.po.User;
import com.leichuangkj.async.service.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.concurrent.Future;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserImpl userImpl;

    @RequestMapping(value = "/findAllSync",method = RequestMethod.GET)
    public void findAllSync(){
        long start = System.currentTimeMillis();
        System.out.println("第一次查询所有用户");
        List<User> userList1 = userImpl.findAllSync();
        System.out.println("第二次查询所有用户");
        List<User> userList2 = userImpl.findAllSync();
        System.out.println("第三次查询所有用户");
        List<User> userList3 = userImpl.findAllSync();
        long end = System.currentTimeMillis();
        System.out.println("总共消耗:"+ (end - start) + "毫秒");
    }

    @RequestMapping(value = "/findAllAsync",method = RequestMethod.GET)
    public void findAllAsync() throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("第一次查询所有用户");
        Future<List<User>> userList1 = userImpl.findAllAsync();
        System.out.println("第二次查询所有用户");
        Future<List<User>> userList2 = userImpl.findAllAsync();
        System.out.println("第三次查询所有用户");
        Future<List<User>> userList3 = userImpl.findAllAsync();
        while(true){
            if(userList1.isDone()&&userList2.isDone()&&userList3.isDone()){
                break;
            }else{
                Thread.sleep(10);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("总共消耗:"+ (end - start) + "毫秒");
    }
}
