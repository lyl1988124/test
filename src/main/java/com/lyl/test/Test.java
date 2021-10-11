package com.lyl.test;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.text.ParseException;

import java.util.*;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.stream.Collectors;

/**
 * Created by lyl on 2017/7/10.
 */
public class Test {
    static  class Car{

        public Car(String color) {
            this.color = color;
        }

        public Car() {
        }

        String color;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return color;
        }
    }

    static  class Process{
        public  void function1(Car car){
            car.setColor("blue");
        }

        public void function2(Car car){
            Car car2 = new Car();
            car2.setColor("black");
            car = car2;
        }
    }

    private int number;


    public static void main(String[] args) throws ParseException, NoSuchFieldException {
        DoubleAdder da =  new DoubleAdder();
        da.add(1);
        System.out.println(da);
        System.out.println(da);

    }
    private int @SpecialNumber[] number2;


    @Target({ ElementType.TYPE_USE })
    @Retention(RetentionPolicy.RUNTIME)
    private @interface SpecialNumber {
    }

    private static  int a(){
        System.out.println("走a");
        return 1;
    }

    private static int b(){
        System.out.println("走b");
        return 2;
    }

    private static int c(){
        System.out.println("走c");
        return 3;
    }

    public static int[] twoSum(int[] nums, int target) {
        int tmp=0;
        List<Integer> list = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            list.add(nums[i]);
        }

        int[]  result = new int[]{};

        for(int i=0;i<list.size();i++){
            tmp = target-list.get(i);
            if(-1!=list.indexOf(tmp)){
                System.out.println(i+","+list.indexOf(tmp));
                return new int[]{i,list.indexOf(tmp)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
