package com.leichuangkj.globalexception.common;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ServerResponse errorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error("{} exception",req.getRequestURI(),e);
        return ServerResponse.createByErrorCodeMessageData(ResponseCode.ERROR.getCode(),"接口异常，详情请查看服务端日志！",e.toString());
    }
}
