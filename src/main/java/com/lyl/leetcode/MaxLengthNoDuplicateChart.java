package com.lyl.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyl
 * Date 2019/10/28 21:19
 */
public class MaxLengthNoDuplicateChart {


    public static int getMaxLengthNoDuplicateChart(String s){
        Map<Character,Integer> map = new HashMap<>();
        int ans = 0, i = 0;

        for(int j=0;j<s.length();j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            ans = Math.max(ans,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(MaxLengthNoDuplicateChart.getMaxLengthNoDuplicateChart("abcabcbbabcd"));
    }
}
