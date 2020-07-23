package com.leichuangkj.endpoint.actuator;

import com.leichuangkj.endpoint.service.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "userEndPoint")
public class UserEndPoint{

    @Autowired
    private UserImpl userImpl;

    @ReadOperation
    public Map<String,Object> invoke(){
        Map<String,Object> map = new HashMap<>();
        map.put("currentTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        map.put("userTotal",userImpl.getTotalNum());
        return map;
    }
}
