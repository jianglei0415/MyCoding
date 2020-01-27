package com.springboot.chapter4.aspect.controller;

import com.springboot.chapter4.aspect.service.UserService;
import com.springboot.chapter4.aspect.validator.UserValidator;
import com.springboot.chapter4.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: jianglei
 * @date: 2020/1/27 22:49
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/print")
    @ResponseBody
    public User printUser(Long id, String userName, String note) {
        User user = new User();
        user.setId(id);
        user.setUsername(userName);
        user.setNote(note);
        userService.printUser(user);
        return user;
    }

    @RequestMapping("vp")
    @ResponseBody
    public User validateAndPrint(Long id, String userName, String note) {
        User user = new User();
        user.setId(id);
        user.setUsername(userName);
        user.setNote(note);
        UserValidator userValidator = (UserValidator) this.userService;
        if (userValidator.validate(user)) {
            userService.printUser(user);
        }
        return user;
    }

    @RequestMapping("/manyAspects")
    public String manyAspects() {
        userService.manyAspects();
        return "manyAspects";
    }
}
