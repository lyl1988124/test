package com.lyl.springboot.aop;

import org.apache.commons.lang3.StringUtils;

public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        // TODO Auto-generated method stub
        if(StringUtils.isEmpty(name)) {
            throw new RuntimeException("parameters is null");
        }
        System.out.println("hello: "+ name);
    }

}
