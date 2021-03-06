package com.lyl.technology.jvm.createAndDestroyObject;

/**
 * Created by lyl
 * Date 2019/12/12 19:54
 * VM Args : -Xss128k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            e.printStackTrace();
        }
    }
}
