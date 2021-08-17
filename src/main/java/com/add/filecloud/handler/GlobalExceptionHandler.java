package com.add.filecloud.handler;

import com.add.filecloud.pojo.JSONResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Object exceptionHandler(HttpServletRequest req,
                                                 Exception e) {
        JSONResponse json = new JSONResponse();
        json.setCode("ERROR000");
        json.setMessage(e.getMessage());
        log.error("未知错误", e);
        return json;
    }



}
