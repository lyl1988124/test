package com.lyl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 *
  *无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
  *示例1:
  *输入：S = "qwe"
  *输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
  * 示例2:
  * 输入：S = "ab"
  * 输出：["ab", "ba"]
 */
public class StringCombination {
    
    private List<String> list=new ArrayList<>();
    
    public String combinateString(String param) {
        //校验参数
        if(StringUtils.isBlank(param)){
            return null;
        }
        combinate(param.toCharArray(),0);
        
        //处理返回值
        String[] letterGroup=new String[list.size()];
        for(int i=0;i<letterGroup.length;i++){
            letterGroup[i]=list.get(i);
        }
        return Arrays.toString(letterGroup);
    }
    
    private void combinate(char[] arrayChar,int first){
        if(first==arrayChar.length-1){
            list.add(String.valueOf((arrayChar)));
            return;
        }
        
        for(int i=first;i<arrayChar.length;i++){
            exchange(arrayChar,first,i);
            combinate(arrayChar,first+1);
            exchange(arrayChar,first,i);
        }
    }
    
    private void exchange(char[] arrayChar,int i,int j){
        char temp=arrayChar[i];
        arrayChar[i]=arrayChar[j];
        arrayChar[j]=temp;
    }
    
    public static void main(String[] args) {
        StringCombination sc = new StringCombination();
        System.out.println(sc.combinateString("qwe"));
        System.out.println(sc.combinateString(""));
    }

}
