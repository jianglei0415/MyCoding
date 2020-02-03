package com.springboot.chapter11.controller;

import com.springboot.chapter11.enumeration.SexEnum;
import com.springboot.chapter11.exception.NotFoundException;
import com.springboot.chapter11.pojo.User;
import com.springboot.chapter11.service.UserService;
import com.springboot.chapter11.util.Change;
import com.springboot.chapter11.vo.UserVo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/31 11:27
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/restful")
    public String index() {
        return "restful";
    }

    @Data
    public class ResultVo {
        private Boolean success;
        private String message;

        public ResultVo() {
        }

        public ResultVo(Boolean success, String message) {
            this.success = success;
            this.message = message;
        }
    }

    @PostMapping("/user")
    @ResponseBody
    public User insertUser(@RequestBody UserVo userVo) {
        User user = Change.changeToPo(userVo);
        int i = userService.insertUser(user);
        user.setId((long) i);
        return user;
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public UserVo getUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        return Change.changeToVo(user);
    }

    @GetMapping("/users/{userName}/{note}/{start}/{limit}")
    @ResponseBody
    public List<UserVo> findUsers(@PathVariable("userName") String userName,
                                  @PathVariable("note") String note,
                                  @PathVariable("start") int start,
                                  @PathVariable("limit") int limit) {
        List<User> userList = userService.findUsers(userName, note, start, limit);
        return Change.changeToVoes(userList);
    }

    @PutMapping("/user/{id}")
    @ResponseBody
    public User updateUser(@PathVariable("id") Long id, @RequestBody UserVo userVo) {
        User user = Change.changeToPo(userVo);
        user.setId(id);
        userService.updateUser(user);
        return user;
    }

    @PatchMapping("/user/{id}/{userName}")
    @ResponseBody
    public ResultVo changeUserName(@PathVariable("id") Long id,
                                   @PathVariable("userName") String userName) {
        int result = userService.updateUserName(id, userName);
        ResultVo resultVo = new ResultVo(result > 0, result > 0 ? "更新成功" : "更新失败");
        return resultVo;
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public ResultVo deleteUser(@PathVariable("id") Long id) {
        int result = userService.deleteUser(id);
        ResultVo resultVo = new ResultVo(result > 0, result > 0 ? "更新成功" : "更新用户【" + id + "】失败");
        return resultVo;
    }

    @PatchMapping("/user/name")
    @ResponseBody
    public ResultVo changeUserName2(Long id, String userName) {
        int result = userService.updateUserName(id, userName);
        ResultVo resultVo = new ResultVo(result > 0, result > 0 ? "更新成功" : "更新用户【" + id + "】失败");
        return resultVo;
    }

    @GetMapping("/user/name")
    public String changeUserName() {
        return "change_user_name";
    }

    @GetMapping(value = "/user/exp/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public UserVo getUserForExp(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        if (user == null) {
            throw new NotFoundException(1L, "找不到用户【" + id + "】信息");
        }
        UserVo userVo = Change.changeToVo(user);
        return userVo;
    }
}
