package com.lyl.learn.structure.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ArrayCollection {
    public static List<Integer> makeList(List<Integer> list, int N) {
        list.clear();
        for(int i=0;i<N;i++) {
            list.add(i);
        }
        return list;
    }
    public static List<Integer> makeList2(List<Integer> list, int N) {
        list.clear();
        for(int i=0;i<N;i++) {
            list.add(0,i);
        }
        return list;
    }
    public static int sumList(List<Integer> list) {
        int total = 0;
        for(int i =0 ; i<list.size();i++) {
            total += list.get(i);
        }
        return total;
    }
    
    public static void removeEleVer1(List<Integer> list) {
//        int i = 0;
//        while (i < list.size()) {
//            if(list.get(i)%2 == 0) {
//                list.remove(i);
//            }
//        }
        
        for (int i=0;i < list.size();i++) {
            if(list.get(i)%2 == 0) {
                list.remove(i);
            }
        }
    }
    
    /*
     * 循环迭代器时修改该数据
     * java.util.ConcurrentModificationException
     */
    public static void removeEleVer2(List<Integer> list) {
      for(Integer i : list) {
          if(i%2 == 0) {
              list.remove(i);
          }
      }
    }
    
    public static void removeEleVer3(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            if(iterator.next()%2 == 0) {
                iterator.remove();
            }
        }
      }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List arrayLst = makeList(new ArrayList<Integer>(), 100000);
        System.out.println("ArrayList costTime===>"+(System.currentTimeMillis()-startTime));
        //add
        startTime = System.currentTimeMillis();
        makeList2(new ArrayList<Integer>(), 100000);    

        System.out.println("ArrayList costTime===>"+(System.currentTimeMillis()-startTime));
         
        startTime = System.currentTimeMillis();
        List linkLst = makeList(new LinkedList(), 100000);
        System.out.println("ArrayList costTime===>"+(System.currentTimeMillis()-startTime));
        
        startTime = System.currentTimeMillis();
        makeList2(new LinkedList<Integer>(), 100000);
        System.out.println("ArrayList costTime===>"+(System.currentTimeMillis()-startTime));
        
        
        //get
        startTime = System.currentTimeMillis();
        sumList(arrayLst);
        System.out.println("get ArrayList costTime===>"+(System.currentTimeMillis()-startTime));
                
        startTime = System.currentTimeMillis();
        sumList(linkLst);   
        System.out.println("get linkLst costTime===>"+(System.currentTimeMillis()-startTime));
       
        
        //remove
        startTime = System.currentTimeMillis();
        removeEleVer3(arrayLst);
        System.out.println("remove linkLst costTime===>"+(System.currentTimeMillis()-startTime));
        startTime = System.currentTimeMillis();
        removeEleVer3(linkLst);
        System.out.println("remove linkLst costTime===>"+(System.currentTimeMillis()-startTime));
        System.out.println(linkLst);
    }
}
