package com.lyl.test;

import com.alibaba.fastjson.JSON;

/**
 * <p> Licence     : (C) Copyright 2019-2020, ZettaCloud Xi'an
 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2021/1/20 14:55
 */
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(JSON.toJSONString(person));


    }
}
