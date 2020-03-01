package com.lyl.springboot.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBean implements InvocationHandler{
    private Object target = null;
    
    private Interceptor interceptor;
    
    public static Object getProxyBean(Object target,Interceptor interceptor) {
        ProxyBean proxyBean = new ProxyBean();
        proxyBean.target = target;
        proxyBean.interceptor = interceptor;
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyBean);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation(target,method,args);
        this.interceptor.before();
        Object retObj = null;
        try {
            if(this.interceptor.useAround()) {
                retObj = this.interceptor.around(invocation);
            }else {
                retObj = method.invoke(method, args);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
            exceptionFlag = true;
        }
        this.interceptor.after();
        if(exceptionFlag) {
            this.interceptor.afterThrowing();
        }else {
            this.interceptor.afterReturning();
            return retObj;
        }
        return null;
    }
}
