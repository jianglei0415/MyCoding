package com.springboot.chapter16.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jianglei
 * @date: 2020/2/3 15:05
 */
@RestController
public class CloseController {
    @GetMapping("/close")
    public String close() {
        return "close";
    }
}
