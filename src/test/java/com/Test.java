package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lyl on 2017/7/1.
 */
public class Test {
    public static void main(String[] args) {
       int a =127;
       int b =123456784;
       long c =1234567890123L;

       Long d =null;

       String aaa= String.valueOf(d);
        System.out.println(System.getProperty("user.home") );

        List list = new ArrayList(Arrays.asList(1,2));
        System.out.println(list.contains(0));

    }
}
