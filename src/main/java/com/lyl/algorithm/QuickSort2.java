package com.lyl.algorithm;

public class QuickSort2 {
    
    private static int[] QuickSort2Method(int[] array,int l,int u){
        for(int item : array){
            System.out.print(item+" ");
        }
        System.out.println();
        
        if(l>u) {
            return array;
        }
        
       
        //最左侧元素作为分个数
        int pivot = array[l];
        int left = l+1;
        int right = u;
        
        while(left<=right){
            while(left<=right && array[left]<pivot) {
                left++;
            }
            System.out.println(array[left]);
            while(left<=right && array[right]>=pivot) {
                right--;
            }
            System.out.println(array[right]);
            if(left>right) {
                break;
            }
            int temp = array[left];
            array[left] = array[right];
            array[right]= temp;
        }
        
        int temp = array[right];
        array[right] = array[l];
        array[l] = temp;
        
        QuickSort2Method(array,l,right-1);
        QuickSort2Method(array,right+1,u);
            
        
       return array;
    }
    
    private static int[] QuickSort2Method(int[] array){
        return QuickSort2Method(array,0,array.length-1);
     }
     
    
    public static void main(String[] args) {
        int [] unsortArray = new int[] {6,5,3,1,8,7,2,4};
        String[] aa = {"aa","bb"};
        QuickSort2Method(unsortArray);
        for(int item : unsortArray){
            System.out.print(item+" ");
        }
    }
}
