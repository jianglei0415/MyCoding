package com.springboot.chapter12;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

/**
 * @author: jianglei
 * @date: 2020/1/31 19:49
 */
public class Test {
    public static void main(String[] args) {
        String secret = "uvwxyz";
        PasswordEncoder encoder = new Pbkdf2PasswordEncoder(secret);
        String abc = encoder.encode("abc");
        System.out.println(abc);
        String s = encoder.encode("aaa111");
        System.out.println(s);
    }
}
