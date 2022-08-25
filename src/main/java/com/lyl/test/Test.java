package com.lyl.test;

import java.util.Stack;

/**
 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2021/12/20 15:37
 */
public class Test {


    private static Integer toInt(String value, int radix) {
        int length = value.length();
        char[] chars = value.toCharArray();

        Double d = new Double(0);

        int j = 0;
        for (int i = length - 1; i >= 0; i--) {
            String c = String.valueOf(chars[i]);

            Integer it = Integer.valueOf(c);

            Double temp = it * Math.pow(radix, j);
            d = d + temp;
            j++;
        }

        return d.intValue();
    }

    private static String toRadix(int value, int radix) {
        Stack s = new Stack<Integer>();

        StringBuilder sb = new StringBuilder();
        int tmp = value;
        while (tmp > 0) {
            int v = tmp % radix;
            tmp = tmp / radix;
            s.push(v);
        }
        while (!s.empty()) {
            sb.append(s.pop());
        }
        return sb.reverse().toString();
    }

    static char chs[] = new char[36];

    static {
        for (int i = 0; i < 10; i++) {
            chs[i] = (char) ('0' + i);
        }
        for (int i = 10; i < chs.length; i++) {
            chs[i] = (char) ('A' + (i - 10));
        }
    }

    static String transRadix(String num, int fromRadix, int toRadix) {
        int number = Integer.valueOf(num, fromRadix);
        StringBuilder sb = new StringBuilder();
        while (number != 0) {
            sb.append(chs[number % toRadix]);
            number = number / toRadix;
        }
        return sb.reverse().toString();

    }

    static String transRadix2(String num, int fromRadix, int toRadix) {
        int number = Integer.valueOf(num, fromRadix);
        StringBuilder stringBuilder = new StringBuilder();
        Stack<String> stack = new Stack<>();
        while (number!=0){
            char temp = chs[number%toRadix];
            number = number/toRadix;
            stack.push(String.valueOf(temp));
        }
       while (!stack.empty()){
           stringBuilder.append(stack.pop());
       }

        return stringBuilder.toString();
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println(transRadix2("FF", 16,10));
    }
}
