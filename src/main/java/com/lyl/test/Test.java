package com.lyl.test;

import javafx.util.Pair;
import org.apache.commons.collections.MapUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
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
        System.out.println(Optional.ofNullable(new Car("白色")).map(t -> t.getColor()).orElse("没有啊"));

        // 测试断言 需要配置 VM options: -ea
        boolean isSafe = true;
        assert isSafe : "Not safe at all";
        System.out.println("断言通过!");

        System.out.println(LocalDate.now().lengthOfYear());
        List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
        pairArrayList.add(new Pair<>("version", 6.19));
        pairArrayList.add(new Pair<>("version", 10.24));
        pairArrayList.add(new Pair<>("version", 13.14));
        Map<String, Double> map22 = pairArrayList.stream().collect(
// 生成的 map 集合中只有一个键值对：{version=13.14}
                Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));
        System.out.println(map22);


        List<String> list = new ArrayList<>(2);
        list.add("guan");
        list.add("bao");
        String[] array = list.toArray(new String[0]);
        System.out.println(Arrays.asList(array));

        System.out.println(Instant.now());
        System.out.println(LocalDateTime.now());
        System.out.println(new Date());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.format(dtf));

        SeasonEnum aa = SeasonEnum.SUMMER;
        switch(""){
            case "SPRING":
                break;
            case "SUMMER":
                System.out.println("SUMMER");
            default:
                System.out.println("没有的");
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
