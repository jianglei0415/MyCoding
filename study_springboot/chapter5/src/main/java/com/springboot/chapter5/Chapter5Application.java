package com.springboot.chapter5;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@SpringBootApplication(scanBasePackages = "com")
public class Chapter5Application {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.springboot.chapter5.*");
        mapperScannerConfigurer.setAnnotationClass(Repository.class);
        return mapperScannerConfigurer;
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter5Application.class, args);
    }

}
