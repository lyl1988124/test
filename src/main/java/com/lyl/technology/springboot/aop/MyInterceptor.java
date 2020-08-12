package com.lyl.technology.springboot.aop;

import java.lang.reflect.InvocationTargetException;

public class MyInterceptor implements Interceptor{

    @Override
    public boolean before() {
        // TODO Auto-generated method stub
        System.out.println("before......");
        return true;
    }

    @Override
    public void after() {
        // TODO Auto-generated method stub
        System.out.println("after......");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        // TODO Auto-generated method stub
        System.out.println("around before......");
        Object obj = invocation.proceed();
        System.out.println("around after......");
        return obj;
    }

    @Override
    public void afterReturning() {
        // TODO Auto-generated method stub
        System.out.println("afterReturning ......");
    }

    @Override
    public void afterThrowing() {
        // TODO Auto-generated method stub
        System.out.println("afterThrowing ......");
    }

    @Override
    public boolean useAround() {
        // TODO Auto-generated method stub
        
        return true;
    }

}
