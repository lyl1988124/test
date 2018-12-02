package com.lyl.attempt;

/**
 * Created by lyl on 2017/9/14.
 */
public class MultipleArgument {

    public static void main(String[] args) {
        MultipleArgument e = new MultipleArgument();
        e.sum(2,2);
        e.sum(1,3,4);
    }

    public int sum(int... numbers ){
        int sum=0;
        for(int number : numbers){
            sum+=number;
        }
        System.out.println(sum);
        return sum;
    }


}
