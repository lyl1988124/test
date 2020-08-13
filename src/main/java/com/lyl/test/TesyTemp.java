package com.lyl.test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * <p> Licence     : (C) Copyright 2019-2020, ZettaCloud Xi'an
 * <p> Description : TesyTemp.java
 *
 * @author : liuyuanlong
 * @date : 2020/6/4 17:03
 */
public class TesyTemp {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("abc","bbb");
//        // class java.util.Arrays$ArrayList
//        System.out.println(list.getClass());
        // class [Ljava.lang.String;

//        Object[] objArray = list.toArray();
//
//        System.out.println(objArray.getClass());
//        System.out.println(objArray[0]);
//        objArray[0] = new Object(); // cause ArrayStoreException
        int zzz = 1;
        for(int i=0;i<10;i++){
            zzz=zzz<<1;
            System.out.println(Integer.toBinaryString(zzz));

        }

        Integer a = 0xF;
        Integer b = 0x1F0;

        String aa = Integer.toBinaryString(a);
        String bb = Integer.toBinaryString(b);
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(bb.contains(aa));

    }
}
