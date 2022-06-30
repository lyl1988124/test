package com.lyl.test;

/**

 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2021/12/9 11:53
 */
public class ParentClss {

    protected void Sout(String str){

        String result = process(str);
        System.out.println(result);
    }

    protected String process(String str){
        return str+"process";
    }
}
