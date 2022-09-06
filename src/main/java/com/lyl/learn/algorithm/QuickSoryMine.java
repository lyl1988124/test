package com.lyl.learn.algorithm;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class QuickSoryMine {
    public static void main(String[] args) {
        int[] aa = new int[] {6,1,2,7,9,3,4,5,10,8};
        //int[] aa = new int[] {1,2,3};
        System.out.println(Arrays.toString(qquickSoryMine(aa)) );
    }
    
    public static int[] qquickSoryMine(int[] array){
        subQuickSoryMine(array,0,array.length-1);        
        return array;
    }
    
    public static int[] subQuickSoryMine(int[] array,int left, int right){
        for(int item : array){
            System.out.print(item+" ");
        }
        System.out.println();
        
        if(left>right) {
            return array;
        }
        
        int pivot = array[left]; 
        int low = left+1;
        int high = right;
        
        while(low<=high) {
            
            while(array[low]<pivot && low<=high) {
                low++;
            }
            
            while(array[high]>=pivot && low<=high) {
                high--;
            }
            
//            if(low>=high) {
//                break;
//            }
//            
//            int temp = array[low];
//            array[low] = array[high];
//            array[high] = temp;

            if (low<high) {
              int temp = array[low];
              array[low] = array[high];
              array[high] = temp;
            }


        }
        
        int temp = array[high];
        array[high] = array[left];
        array[left] = temp;
       

        subQuickSoryMine(array,left,high-1);
        subQuickSoryMine(array,high+1,right);
        return array;
    }
}
