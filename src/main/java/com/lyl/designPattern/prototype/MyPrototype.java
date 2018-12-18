package com.lyl.designPattern.prototype;

/**
 * Created by lyl
 * Date 2018/12/18 21:42
 */
public class MyPrototype {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void dosplay(){
        System.out.println("this is MyPrototype"+name);
    }
}
