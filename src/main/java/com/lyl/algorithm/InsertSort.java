package com.lyl.algorithm;

import java.util.Arrays;

/**
 * Created by lyl
 * Date 2019/9/11 17:06
 */
public class InsertSort {

    public static void insertSort(int[] array){
        if(null == array){
            return;
        }
        if(array.length==1){
            return;
        }

        for(int i=1;i<array.length;i++){
            int tmp = array[i];
            int j;
            for(j=i;j>0 && tmp<array[j-1];j--){
                    array[j] = array[j-1];
            }
            array[j]=tmp;
            System.out.println(Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] array = {2,3,5,23,4,6,78,34};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
