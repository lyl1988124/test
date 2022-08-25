package com.lyl.test;

/**
 * Created by lyl
 * Date 2019/9/12 10:09
 */
public class ObjectOfStudy {
    public static void main(String[] args) {
//        String zhangsan, lisi;
//        zhangsan = new String("我是对象张三");
//        lisi = new String("我是对象李四");
//        zhangsan = lisi;
//        System.out.println(zhangsan == lisi);
//        lisi = new String("BB");
//        System.out.println(zhangsan);
//        System.out.println(zhangsan == lisi);
//
//        int a =  3;
//        int b=a;
//         a =4;
//        System.out.println(a);
//        System.out.println(b);

        int c = new Integer(100000);
        int d = c;
        c = new Integer(300000);
        System.out.println(c);
        System.out.println(d);
    }
}
