package com.lyl.test;

import com.lyl.C;

/**

 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2021/12/9 11:55
 */
public class ChilderClss extends ParentClss{

    @Override
    protected String process(String str) {
        return str+"ChilderClss process";
    }

    public static void main(String[] args) {
        ChilderClss childerClss = new ChilderClss();

        System.out.println(childerClss.process("test "));
    }
}
