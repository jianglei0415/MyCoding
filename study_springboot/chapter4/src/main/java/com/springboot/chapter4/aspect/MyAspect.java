package com.springboot.chapter4.aspect;

import com.springboot.chapter4.aspect.validator.UserValidator;
import com.springboot.chapter4.aspect.validator.impl.UserValidatorImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author: jianglei
 * @date: 2020/1/27 22:54
 */
@Aspect
//@Order(1)
public class MyAspect implements Ordered {
    @Pointcut("execution(* com.springboot.chapter4.aspect.service.impl.UserServiceImpl.printUser(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("before......");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after......");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning......");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing......");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before......");
        joinPoint.proceed();
        System.out.println("around after......");
    }

    @DeclareParents(value = "com.springboot.chapter4.aspect.service.impl.UserServiceImpl", defaultImpl = UserValidatorImpl.class)
    public UserValidator userValidator;

    @Override
    public int getOrder() {
        return 1;
    }
}
