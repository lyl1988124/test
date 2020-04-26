package com.lyl.test.beanUtils;

/**
 * <p> Licence     : (C) Copyright 2019-2020, ZettaCloud Xi'an
 * <p> Description : CopyTest1.java
 *
 * @author : liuyuanlong
 * @date : 2020/4/26 13:13
 */
public class TestEntity{
    private Integer age;
    private String name;
    private Inner inner;

    public static class Inner{
        private Integer a;
        public Inner(Integer a){
            this.a = a;
        }

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inner getInner() {
        return inner;
    }

    public void setInner(Inner inner) {
        this.inner = inner;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", inner=" + inner +
                '}';
    }
}
