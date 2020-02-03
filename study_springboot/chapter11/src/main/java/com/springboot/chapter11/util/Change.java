package com.springboot.chapter11.util;

import com.springboot.chapter11.enumeration.SexEnum;
import com.springboot.chapter11.pojo.User;
import com.springboot.chapter11.vo.UserVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jianglei
 * @date: 2020/1/31 13:59
 */
public class Change {
    public static User changeToPo(UserVo userVo) {
        User user = new User();
        user.setId(userVo.getId());
        user.setUserName(userVo.getUserName());
        user.setSex(SexEnum.getEnumById(userVo.getSexCode()));
        user.setNote(userVo.getNote());
        return user;
    }

    public static UserVo changeToVo(User user) {
        UserVo userVo = new UserVo();
        userVo.setId(user.getId());
        userVo.setUserName(user.getUserName());
        userVo.setSexCode(user.getSex().getId());
        userVo.setSexName(user.getSex().getName());
        userVo.setNote(user.getNote());
        return userVo;
    }

    public static List<UserVo> changeToVoes(List<User> poList) {
        List<UserVo> voList = new ArrayList<>();
        for (User user : poList) {
            UserVo userVo = changeToVo(user);
            voList.add(userVo);
        }
        return voList;
    }
}
