package com.springboot.chapter4.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author: jianglei
 * @date: 2020/1/27 22:57
 */
@Aspect
@Order(4)
public class MyAspect3 implements Ordered {
    @Pointcut("execution(* com.springboot.chapter4.aspect.service.impl.UserServiceImpl.manyAspects(..))")
    public void manyAspects() {
    }

    @Before("manyAspects()")
    public void before() {
        System.out.println("MyAspect3 before......");
    }

    @After("manyAspects()")
    public void after() {
        System.out.println("MyAspect3 after......");
    }

    @AfterReturning("manyAspects()")
    public void afterReturning() {
        System.out.println("MyAspect3 afterReturning......");
    }

    @Override
    public int getOrder() {
        return 4;
    }
}
