package com.lyl.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSwap {
    
    public static int[] maximumSwap(int num) {
        String numStr = String.valueOf(num);
        List<String> numList = new ArrayList();
        int[] intArr = new int[numStr.length()];
        for(int i=0; i<intArr.length;i++) {
            numList.add(String.valueOf(numStr.charAt(i)));
            intArr[i] = Integer.valueOf(String.valueOf(numStr.charAt(i)));
        }
        System.out.println(numList);
        
        System.out.println(Arrays.toString(insertSort(intArr)));
        
        int max=0;
        int move=0;
        for(int j=numList.size()-1,i=0;j>=0;j--,i++) {
            String fromInt =String.valueOf(intArr[j]);
            String fromList = numList.get(i);
            if(!fromInt.equals(fromList)) {
                System.out.println( intArr[j] + "   "+numList.get(i));
                max=i;
                move=numList.indexOf(String.valueOf(intArr[j]));
                
                System.out.println( max + "   "+move);
                break;
            }
        }
        if(max != move) {
            String temp = numList.get(max);
            numList.set(max, numList.get(move));;
            numList.set(move,temp);
            System.out.println(numList);
        }

        return null;
    }
    
    private static int[] insertSort(int[] nums) {

        for(int i=1;i<nums.length;i++) {
            int idx = nums[i];
            int j;
            for(j=i;j>0 && idx < nums[j-1];j--) {
                nums[j] = nums[j-1];
            }
            nums[j] = idx;
            
        }
        
        return nums;
    }

    public static void main(String[] args) {
        maximumSwap(2736);
    }
}
