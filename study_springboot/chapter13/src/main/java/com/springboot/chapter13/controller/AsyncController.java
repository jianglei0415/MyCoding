package com.springboot.chapter13.controller;

import com.springboot.chapter13.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: jianglei
 * @date: 2020/2/1 16:49
 */
@Controller
@RequestMapping("/async")
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping("/page")
    public String asyncPage() {
        System.out.println("请求线程名称：【" + Thread.currentThread().getName() + "】");
        asyncService.generateReport();
        return "async";
    }
}
