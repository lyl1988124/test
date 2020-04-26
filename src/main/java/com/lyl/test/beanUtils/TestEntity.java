package com.lyl.test.beanUtils;

import lombok.Data;

/**
 * <p> Licence     : (C) Copyright 2019-2020, ZettaCloud Xi'an
 * <p> Description : CopyTest1.java
 *
 * @author : liuyuanlong
 * @date : 2020/4/26 13:13
 */
@Data
public class TestEntity{
    private Integer age;
    private String name;
    private Inner inner;

    @Data
    public static class Inner{
        private Integer a;
        public Inner(Integer a){
            this.a = a;
        }
    }

}
