package com.springboot.chapter4.aspect.validator;

import com.springboot.chapter4.pojo.User;

/**
 * @author: jianglei
 * @date: 2020/1/27 22:53
 */
public interface UserValidator {
    boolean validate(User user);
}
