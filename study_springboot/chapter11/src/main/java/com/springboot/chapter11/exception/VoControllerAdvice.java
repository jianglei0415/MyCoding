package com.springboot.chapter11.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: jianglei
 * @date: 2020/1/31 14:56
 */
@ControllerAdvice(basePackages = "com.springboot.chapter11.controller.*",
        annotations = {Controller.class, RestController.class})
public class VoControllerAdvice {
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> exception(HttpServletRequest request, NotFoundException ex) {
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("code", ex.getCode());
        msgMap.put("message", ex.getCustomMsg());
        return msgMap;
    }
}
