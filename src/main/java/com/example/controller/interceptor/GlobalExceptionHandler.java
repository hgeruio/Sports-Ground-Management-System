package com.example.controller.interceptor;

import com.example.controller.exception.TokenAuthExpiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class GlobalExceptionHandler {
    /**
     * 用户 token 过期
     * @return
     */
    @ExceptionHandler(value = TokenAuthExpiredException.class)
    @ResponseBody
    public String tokenExpiredExceptionHandler(){
        System.out.println("用户 token 过期");
        return "用户 token 过期";
    }
}
