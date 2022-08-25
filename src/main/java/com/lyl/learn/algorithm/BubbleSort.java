package com.lyl.learn.algorithm;

import java.util.Arrays;

/**
 * Created by lyl
 * Date 2019/9/17 16:35
 */
public class BubbleSort {
    public void bubbleSort(Integer[] arr) {
        int length = arr.length;
        if(length<=1)
            return;
        boolean flag;
        for(int i=0;i<length;i++){
            flag = false;
            //length-i-1  减1是因为j和j+1比较；减i是因为冒泡每次会把最大的数推到最后一位，所以最后一位不用再次比较；
            for(int j=0; j<length-i-1;j++){
                if(arr[j+1]<arr[j]){
                    int tmp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = tmp;
                    flag=true;

                }
                System.out.println(Arrays.toString(arr));
            }
            System.out.println("###");
//            if(!flag){
//                break;
//            }
//            System.out.println(Arrays.toString(arr));

        }
    }

    public static void main(String[] args) {
        BubbleSort t = new BubbleSort();
        Integer arr[] = new Integer[]{13,26,22,9,35,18};
        t.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
