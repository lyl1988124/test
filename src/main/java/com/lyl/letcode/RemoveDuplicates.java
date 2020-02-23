package com.lyl.letcode;

import java.util.Arrays;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {            
            if(nums[idx] != nums[i]) {
                idx+=1;
                nums[idx]=nums[i];
            }
        }
        for(int i=0;i<idx;i++){
            System.out.print(nums[i]);
        }
        return idx+1;
    }
    
    public static void main(String[] args) {
        int[] aa = {0,0,1,1,1,2,2,3,3,4};
        int result = RemoveDuplicates.removeDuplicates(aa);
        System.out.println(Arrays.toString(aa));
        System.out.println(result);
    }
}
