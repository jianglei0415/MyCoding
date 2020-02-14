package com.springboot.chapter8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.springboot.chapter8")
public class Chapter8Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter8Application.class, args);
    }

}
