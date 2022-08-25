package com.lyl.test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**

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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("name", name)
            .append("age", age)
            .toString();
    }

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(JSON.toJSONString(person));


    }
}
