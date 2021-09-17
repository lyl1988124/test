package com.lyl.test;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Licence     : (C) Copyright 2019-2020, ZettaCloud Xi'an
 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2021/1/22 13:58
 */
public class TmpTest {
    public static void main(String[] args) {
        List<Integer> test= new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(0,100);

        test.stream().forEach(
            t ->
                System.out.println(t)
        );
    }
}


