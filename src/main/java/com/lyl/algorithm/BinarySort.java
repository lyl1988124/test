package com.lyl.algorithm;

/**
 * 二分查找
 * @author lyl_pc
 *
 */
public class BinarySort {
    
    public static void main(String[] args) {
       // int[] aa = new int[] {1, 2, 3, 4,5, 6, 7, 8, 9, 10};
        int[] aa = new int[] {1, 2, 3};
        //System.out.println(binaryLoop(aa,4));
        System.out.println(subBinaryIteration(aa,3,0,aa.length));
    }
    
    /**
     * 循环方式查找
     * @param array
     * @param key
     * @return
     */
    public static int binaryLoop(int[] array, int key) {
        int low = 0;
        int high = array.length;
        
        while(low<=high) {
            int middle = (low+high)/2;
            if(key == array[middle]) {
                return middle;
            }else if(key > array[middle]) {
                low = middle+1;
            }else {
                high=middle-1;
            }
        }
        return -1;
    }
    
    /**
     * 迭代方式查找
     * @param array
     * @param key
     * @param low
     * @param high
     * @return
     */
    private static int subBinaryIteration(int[] array, int key,int low,int high) {
        if(low<=high) {
            int middle = (low+high)/2;
            if(key == array[middle]) {
                return middle;
            }else if(key > array[middle]) {
                return subBinaryIteration(array,key,middle+1,high);
            }else {
                return subBinaryIteration(array,key,low,middle-1);
            }
        }
        return -1;
    }
    
}
