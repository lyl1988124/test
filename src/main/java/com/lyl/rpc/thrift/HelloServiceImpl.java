package com.lyl.thrift;

import org.apache.thrift.TException;

/**
 * Created by lyl on 2018/6/22.
 */
public class HelloServiceImpl implements HelloService.Iface{
    @Override
    public String helloString(MyParam para) throws TException {
        String result = para.getPara();
        return "HelloServiceImpl:"+result;
    }
}
