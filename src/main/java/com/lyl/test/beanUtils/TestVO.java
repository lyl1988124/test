package com.lyl.test.beanUtils;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * <p> Licence     : (C) Copyright 2019-2020, ZettaCloud Xi'an
 * <p> Description : CopyTest2.java
 *
 * @author : liuyuanlong
 * @date : 2020/4/26 13:18
 */
@Data
public class TestVO{
    private Integer age;
    private String name;

    // ### start 可被 private TestEntity.Inner inner; 替换
    private Inner inner;

    @Data
    public static class Inner{
        private Integer a;
        public Inner(Integer a){
            this.a = a;
        }
    }
    // ### end 可被 private TestEntity.Inner inner; 替换

//###    private TestEntity.Inner inner;

}
