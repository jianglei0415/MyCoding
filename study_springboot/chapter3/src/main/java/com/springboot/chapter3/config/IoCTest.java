package com.springboot.chapter3.config;

import com.springboot.chapter3.pojo.BusinessPerson;
import com.springboot.chapter3.pojo.User;
import com.springboot.chapter3.pojo.definition.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: jianglei
 * @date: 2020/1/27 22:36
 */
@Slf4j
public class IoCTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = ctx.getBean(User.class);
        log.info(user.toString());

        Person person=ctx.getBean(BusinessPerson.class);
        person.service();
    }
}
