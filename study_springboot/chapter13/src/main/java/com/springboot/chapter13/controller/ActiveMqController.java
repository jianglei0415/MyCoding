package com.springboot.chapter13.controller;

import com.springboot.chapter13.pojo.User;
import com.springboot.chapter13.service.ActiveMqService;
import com.springboot.chapter13.service.ActiveMqUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: jianglei
 * @date: 2020/2/1 21:09
 */
@RestController
@RequestMapping("/activemq")
public class ActiveMqController {
    @Autowired
    private ActiveMqService activeMqService;

    @Autowired
    private ActiveMqUserService activeMqUserService;

    private Map<String, Object> result(Boolean success, Object message) {
        Map<String, Object> result = new HashMap<>(2);
        result.put("success", success);
        result.put("message", message);
        return result;
    }

    @GetMapping("/msg")
    public Map<String, Object> msg(String message) {
        activeMqService.sendMsg(message);
        return result(true, message);
    }

    @GetMapping("/user")
    public Map<String, Object> sendUser(Long id, String userName, String note) {
        User user = new User(id, userName, note);
        activeMqUserService.sendUser(user);
        return result(true, user);
    }
}
