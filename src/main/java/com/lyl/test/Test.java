package com.lyl.test;

import com.google.common.collect.Maps;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.collections.MapUtils;
import org.python.google.common.primitives.Ints;
import scala.Int;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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


    public static void main(String[] args) throws ParseException {
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

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       // sdf.parse("1544004682000L");

        int a=1;
        int b=2;
        int c=3;

        if(a!=a()||b!=b()&&c==c()){
            System.out.println("GG");
        }

        Map<String, Long> map = null;
        if (MapUtils.isNotEmpty(map)) {
            System.out.println("aa");
        }
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
