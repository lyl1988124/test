package com;

import org.springframework.util.comparator.ComparableComparator;

import java.util.*;

/**
 * Created by lyl on 2017/7/1.
 */
public class Test {
    public static void main(String[] args) {
//       int a =127;
//       int b =123456784;
//       long c =1234567890123L;
//
//       Long d =null;
//
//       String aaa= String.valueOf(d);
//        System.out.println(System.getProperty("user.home") );
//
//        List list = new ArrayList(Arrays.asList(1,2));
//        System.out.println(list.contains(0));
//
//        Queue<Integer> queue = new ArrayDeque();
//        queue.add(10);
//        queue.add(2);
//        System.out.println(queue.remove());
//        int aa =queue.remove();


        System.out.println( pancakeSort(new int[]{3,2,4,1}));
    }


    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList();
        int N = A.length;

        Integer[] B = new Integer[N];

        for (int i = 0; i < N; ++i)
            B[i] = i+1;
        Arrays.sort(B, (i, j) -> A[j-1] - A[i-1]);



        for(int tmp : B){
            System.out.println(tmp);
        }


        for (int i: B) {
            for (int f: ans)
                if (i <= f)
                    i = f+1 - i;
            ans.add(i);
            ans.add(N--);
        }

        return ans;
    }
}
