package com.lyl.test.beanUtils;

import org.springframework.beans.BeanUtils;

/**
 * <p> Licence     : (C) Copyright 2019-2020, ZettaCloud Xi'an
 * <p> Description : beanUtilsTest.java
 *
 * @author : liuyuanlong
 * @date : 2020/4/26 13:19
 */
public class beanUtilsTest {
    public static void main(String args[]){
        TestEntity entity = new TestEntity();
        entity.setAge(1);
        entity.setName("hehe");
        entity.setInner(new TestEntity.Inner(1));

        TestVO vo = new TestVO();
        BeanUtils.copyProperties(entity,vo);
        System.out.println(vo.toString());

    }
}
