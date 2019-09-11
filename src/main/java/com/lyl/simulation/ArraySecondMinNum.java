package com.lyl.simulation;

public class ArraySecondMinNum {
	
	public void start() {
        int [] arr ={-1,1,2,3,9,7,66,5,4,3,2,9,0,1,4};
        System.out.println(method(arr));
    }


	public int method(int [] arr){
		 Integer []minNum=new Integer[2];
		 minNum[0] = Integer.MAX_VALUE;
		 minNum[1] = Integer.MAX_VALUE;
		 
		for(int i=0;i<arr.length;i++) {
			 if(minNum[0]>arr[i]) {
				 minNum[1] = minNum[0];
				 minNum[0] = arr[i];
			 }else if(minNum[1]>arr[i]) {
				 minNum[1] = arr[i];
			 }
		 }
		
		return minNum[1];
	}
	
	public static void main(String[] args) {
		ArraySecondMinNum arrMinNum = new ArraySecondMinNum();
		arrMinNum.start();
	}
}
