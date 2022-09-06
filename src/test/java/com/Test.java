package com;

import jnr.ffi.annotations.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lyl on 2017/7/1.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        Integer a = new Integer(1000);
        test.triple(a);
        System.out.println("x=" + a);
    }

    private void triple(Integer a) {
        a = a *3;
        System.out.println("triple=" + a);
    }


    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList();
        int N = A.length;

        Integer[] B = new Integer[N];

        for (int i = 0; i < N; ++i)
            B[i] = i + 1;
        Arrays.sort(B, (i, j) -> A[j - 1] - A[i - 1]);


        for (int tmp : B) {
            System.out.println(tmp);
        }


        for (int i : B) {
            for (int f : ans)
                if (i <= f)
                    i = f + 1 - i;
            ans.add(i);
            ans.add(N--);
        }

        return ans;
    }
}
