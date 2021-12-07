package com.lyl.test;



import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class TestChar {

    public static void main(String[] args) {
        int num=705;
        System.out.println(convert(num));
    }
    public static String convert(int num){
        int size=26;
        StringBuffer sb=new StringBuffer();
        boolean have=true;
        while(have){
            sb.insert(0,(char)((num-1)%size+97));
            num=(num-1)/size;
            if (num==0){
                have=false;
            }
        }
        Map<String,String> map = new Hashtable();
        Map<String,String> map2 = new HashMap();
        return sb.toString();
    }
}
