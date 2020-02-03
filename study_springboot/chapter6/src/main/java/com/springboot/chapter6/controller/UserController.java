package com.springboot.chapter6.controller;

import com.springboot.chapter6.pojo.User;
import com.springboot.chapter6.service.UserBatchService;
import com.springboot.chapter6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: jianglei
 * @date: 2020/1/27 23:32
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserBatchService userBatchService;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id) {
        return userService.getUser(id);
    }

    @ResponseBody
    @RequestMapping("/insertUser")
    public Map<String, Object> insertUser(String userName, String note) {
        User user = new User();
        user.setUserName(userName);
        user.setNote(note);
        int update = userService.insertUser(user);
        Map<String, Object> result = new HashMap<>();
        result.put("success", update == 1);
        result.put("user", user);
        return result;
    }

    @RequestMapping("/insertUsers")
    @ResponseBody
    public Map<String, Object> insertUsers(String userName1, String note1, String userName2, String note2) {
        User user1 = new User();
        user1.setUserName(userName1);
        user1.setNote(note1);
        User user2 = new User();
        user2.setUserName(userName2);
        user2.setNote(note2);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        int inserts = userBatchService.insertUsers(userList);
        Map<String, Object> result = new HashMap<>();
        result.put("success", inserts > 0);
        result.put("user", userList);
        return result;
    }

}
