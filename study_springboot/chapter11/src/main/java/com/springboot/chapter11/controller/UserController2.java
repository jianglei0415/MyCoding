package com.springboot.chapter11.controller;

import com.springboot.chapter11.pojo.User;
import com.springboot.chapter11.service.UserService;
import com.springboot.chapter11.util.Change;
import com.springboot.chapter11.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: jianglei
 * @date: 2020/1/31 13:56
 */
@RestController
public class UserController2 {
    @Autowired
    private UserService userService;

    @GetMapping("/restful2")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("restful");
        return mv;
    }

    @GetMapping("/user2/{id}")
    public UserVo getUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        return Change.changeToVo(user);
    }

    @GetMapping(value = "/user2/name/{id}",
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String getUserName(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        return user.getUserName();
    }

    @PostMapping("/user2/entity")
    public ResponseEntity<UserVo> insertUserEntity(
            @RequestBody UserVo userVo) {
        User user = Change.changeToPo(userVo);
        userService.insertUser(user);
        UserVo result = Change.changeToVo(user);
        HttpHeaders headers = new HttpHeaders();
        String success =
                (result == null || result.getId() == null) ? "false" : "true";
        headers.add("success", success);
        return new ResponseEntity<>(result, headers, HttpStatus.CREATED);
    }

    @PostMapping("/user2/annotation")
    @ResponseStatus(HttpStatus.CREATED)
    public UserVo insertUserAnnotation(@RequestBody UserVo userVo) {
        User user = Change.changeToPo(userVo);
        userService.insertUser(user);
        UserVo result = Change.changeToVo(user);
        return result;
    }
}
