package com.lyl.leetcode;

import java.util.Arrays;

public class SwapNumbers {
    
    public static int[] swapNumbers(int[] numbers) {
        numbers[0]+=numbers[1];
        numbers[1]-=numbers[0];
        numbers[0]+=numbers[1];
        numbers[1]=-numbers[1];
        return numbers;
    }
    
    public static void main(String[] args) {
        int[] aa = new int[] {1,2};
        System.out.println(Arrays.toString(swapNumbers(aa)));
    }

}
