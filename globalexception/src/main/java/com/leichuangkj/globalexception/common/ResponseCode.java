package com.leichuangkj.globalexception.common;

public enum ResponseCode {
    //1.定义枚举值
    ERROR(0,"ERROR"),

    SUCCESS(1,"SUCCESS");

    //2.定义枚举属性
    private final int code;

    private final String desc;

    //3.定义构造函数
    ResponseCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    //4.定义get方法
    public int getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }
}
