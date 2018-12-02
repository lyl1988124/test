package com.lyl.test;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.python.google.common.primitives.Ints;
import scala.Int;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lyl on 2017/7/10.
 */
public class Test {
    static  class Car{
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


    public static void main(String[] args) {
//        Process p = new Process();
//        Car car = new Car();
//        car.setColor("red");
//        System.out.println(car);
//        p.function2(car);
//        System.out.println(car);


//        int[] a = new int[]{1,3,4};
//        List<Integer> list = Ints.asList(a);
//        System.out.println(list.get(0));
//        System.out.println(list.indexOf(1));

        twoSum(new int[]{1,2,7,11,15},9);

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
