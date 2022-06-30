package com.lyl.test;

import javassist.ClassPool;

import java.math.BigDecimal;
import java.net.URL;

/**

 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2021/12/20 15:37
 */
public class Test {

    public static void main(String[] args) {
        ClassPool classPool = ClassPool.getDefault();
        URL url =classPool.find("com.lyl.test.Test");

        System.out.println(url);
    }
}
