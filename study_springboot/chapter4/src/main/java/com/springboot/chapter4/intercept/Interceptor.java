package com.springboot.chapter4.intercept;

import com.springboot.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @author: jianglei
 * @date: 2020/1/27 22:57
 */
public interface Interceptor {
    boolean before();

    void after();

    Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    void afterReturning();

    void afterThrowing();

    boolean useAround();
}
