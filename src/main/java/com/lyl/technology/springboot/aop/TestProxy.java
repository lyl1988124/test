package com.lyl.technology.springboot.aop;

import java.util.Scanner;

public class TestProxy {
    
    private static void testProxy() {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
        proxy.sayHello("lyl");
        System.out.println("\n ####################### name is null ################");
        proxy.sayHello(null);
        
    }
//    public static void main(String[] args) {
//        TestProxy.testProxy();
//    }
//    public static void main(String args[]) { 
//        int num=5;
//        String two = Integer.toBinaryString(num);
//       System.out.println(two);
//       char[] array = two.toCharArray();
//       if(null!=array){
//            for(char s:array){
//                if(s=='1') {
//                    System.out.println(s);
//                }
//           }
//       }
//   } 
    public static int lengthOfLast(String str) {
        String[] s =str.split(" ");
        return s[s.length-1].length();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            System.out.println(lengthOfLast(str));
        }
    }
}
