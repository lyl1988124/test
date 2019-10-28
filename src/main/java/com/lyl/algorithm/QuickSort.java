package com.lyl.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lyl
 * Date 2019/10/9 08:30
 */
public class QuickSort {

    public static  void  sort(List<Integer> items){
        if(items.size()>1){
            List<Integer> smaller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();

            Integer choseItem = items.get(items.size()/2);

            for(Integer item : items){
                if(item<choseItem){
                    smaller.add(item);
                }else if(item == choseItem){
                    same.add(item);
                }else {
                    larger.add(item);
                }
            }

            sort(smaller);
            sort(larger);

            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
            System.out.println(items);
        }
    }

    public static void main(String[] args) {
        List<Integer> items = new ArrayList<>(Arrays.asList(10,2,6,9));
        sort(items);
        System.out.println(items);
    }
}
