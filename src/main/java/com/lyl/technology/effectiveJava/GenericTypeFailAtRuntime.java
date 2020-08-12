package com.lyl.technology.effectiveJava;

import java.util.ArrayList;
import java.util.List;

public class GenericTypeFailAtRuntime {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        unsafeAdd(list,121212);
        System.out.println(list.get(0));
    }
    
    private static void unsafeAdd(List list,Object o) {
        list.add(o);
    }

}
