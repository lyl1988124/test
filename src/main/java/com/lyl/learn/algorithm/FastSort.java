package com.lyl.learn.algorithm;

/**
 * Created by lyl
 * Date 2019/2/21 20:27
 */
public class FastSort {

    public static int getMiddle(int[] numbers, int low,int high){

        //假定设置中位
        int tmp = numbers[low];

        while (low < high){

            while(low < high && tmp < numbers[high]){
                high--;
            }
            System.out.println("high===>"+high);

            numbers[low] = numbers[high];

            while (low < high && numbers[low] < tmp){
                low++;
            }

            numbers[high]=numbers[low];

            printTmp(numbers);

        }

        numbers[low] = tmp;

        return low;
    }


    public static void quickSort(int[] numbers,int low,int high){
        if(low < high){
            int middle = getMiddle(numbers,low,high);
            quickSort(numbers,low,middle-1);
            quickSort(numbers,middle+1,high);
        }
    }

    private static void  printTmp(int[] numbers){
        for(int i : numbers){
            System.out.print(i+",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = {10,20,-15,0,6,7,2,1,-5,55};
        quickSort(numbers,0,numbers.length-1);
        printTmp(numbers);


    }
}
