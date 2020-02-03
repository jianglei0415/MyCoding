package com.springboot.chapter6;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;

@MapperScan(basePackages = "com.springboot.chapter6", annotationClass = Repository.class)
@SpringBootApplication(scanBasePackages = "com.springboot.chapter6")
public class Chapter6Application {
    @Autowired
    PlatformTransactionManager transactionManager;

    @PostConstruct
    public void viewTransactionManager() {
        System.out.println(transactionManager.getClass().getName());
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter6Application.class, args);
    }

}
