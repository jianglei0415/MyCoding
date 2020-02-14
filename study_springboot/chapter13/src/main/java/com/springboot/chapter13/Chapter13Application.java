package com.springboot.chapter13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(scanBasePackages = "com.springboot.chapter13")
@EnableScheduling
public class Chapter13Application extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder)
                .withUser("user1")
                .password("$2a$10$fvqrhnROnceNuZ112EsiuO2/.1b4AS9EET8NmPW18DW064/N07akO")
                .roles("USER")
                .and().withUser("user2")
                .password("$2a$10$koZgAJmAd5A5Kh1WCNqQ3uZ3.yWsieMJh1o8chczxLK8get0tBzA2")
                .roles("ADMIN")
                .and().withUser("user3")
                .password("$2a$10$RwUJFWE02hVcQktT5Oy7ZOYKvCQf44.Du4kO7RSNs5gkv7CowBGzK")
                .roles("USER");
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter13Application.class, args);
    }

}
