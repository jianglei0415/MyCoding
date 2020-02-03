package com.springboot.chapter16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Chapter16Application extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder)
                .withUser("admin")
                //密码abc
                .password("$2a$10$ajW5HJQfq.GPg51ooxyIneiagHyp5FG2pntlK0gWYEPi.tPh64LCW")
                .roles("USER", "ADMIN")
                .and()
                .withUser("myuser")
                //密码123456
                .password("$2a$10$SwgO9nRmOzAXUaKu1vpF0.Aafwxzm0QGguekRfP7SrwartIxgRANC")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] endPoints = {"auditevents", "beans", "conditions",
                "configprops", "env", "flyway",
                "httptrace", "loggers", "liquibase", "metrics",
                "mappings", "Scheduledtasks",
                "sessions", "shutdown", "threaddump"};
        http.requestMatcher(EndpointRequest.to(endPoints))
                .authorizeRequests()
                .anyRequest()
                .hasRole("ADMIN")
                .and()
                .antMatcher("/close")
                .authorizeRequests()
                .anyRequest()
                .hasRole("ADMIN")
                .and()
                .httpBasic();
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter16Application.class, args);
    }

}
