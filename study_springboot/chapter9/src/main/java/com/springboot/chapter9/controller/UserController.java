package com.springboot.chapter9.controller;

import com.springboot.chapter9.pojo.User;
import com.springboot.chapter9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/29 13:55
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/details")
    public ModelAndView details(Long id) {
        User user = userService.getUser(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/details");
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping("/detailsForJson")
    public ModelAndView detailsForJson(Long id) {
        User user = userService.getUser(id);
        ModelAndView mv = new ModelAndView();
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        mv.setView(jsonView);
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping("/table")
    public ModelAndView table() {
        List<User> userList = userService.findUsers(null, null);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/table");
        mv.addObject("userList", userList);
        return mv;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<User> list(@RequestParam(value = "userName",required = false) String userName,
                           @RequestParam(value = "note",required = false) String note){
        List<User> userList=userService.findUsers(userName,note);
        return userList;
    }
}
