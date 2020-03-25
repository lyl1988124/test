package com.lyl.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Codec {
    static Map<Integer, String> map = new HashMap();

    public static String encode(String longUrl) {
        map.put(longUrl.hashCode(), longUrl);
        return "http://tinyurl.com/" + longUrl.hashCode();
    }

    public static String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
    
    public static void main(String[] args) {
        System.out.println(encode("lyl"));
        System.out.println(decode(encode("lyl")));
        Map<String,String> map = new HashMap<String, String>();
        map.put("aa", "bb");
    }
}
