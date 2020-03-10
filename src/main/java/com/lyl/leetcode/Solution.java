package com.lyl.leetcode;

/**
 * Created by lyl
 * Date 2019/2/25 20:56
 */
public class Solution {

    public static boolean isPalindrome(int x){

        if(x<0 || (x%10==0 && x!=0)){
            return false;
        }

        int revertedNumber = 0;

        while(x>revertedNumber){
            revertedNumber = revertedNumber*10 + x%10;
            System.out.println("revertedNumber===>"+revertedNumber);
            x/=10;
            System.out.println("x===>"+x);
        }

        return x==revertedNumber || x==revertedNumber/10;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
    }
}
