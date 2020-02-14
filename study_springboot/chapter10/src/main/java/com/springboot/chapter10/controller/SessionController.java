package com.springboot.chapter10.controller;

import com.springboot.chapter10.pojo.User;
import com.springboot.chapter10.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author: jianglei
 * @date: 2020/1/30 23:12
 */
@Controller
@RequestMapping("/session")
@SessionAttributes(names = {"user"}, types = Long.class)
public class SessionController {
    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test(@SessionAttribute("id") Long id, Model model) {
        model.addAttribute("id_new", id);
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "session/test";
    }
}
