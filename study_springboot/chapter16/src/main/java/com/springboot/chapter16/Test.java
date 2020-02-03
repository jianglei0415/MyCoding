package com.springboot.chapter16;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: jianglei
 * @date: 2020/2/3 14:42
 */
public class Test {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String abc = passwordEncoder.encode("abc");
        System.out.println(abc);
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
    }
}
