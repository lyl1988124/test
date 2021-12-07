package com.lyl.test;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lyl on 2017/7/13.
 */
public class TestMD5 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String s ="100019536699";
        // 将字符串转为字节数组
        byte[] strTemp = s.getBytes();
        // 加密器
        MessageDigest mdTemp = MessageDigest.getInstance("MD5");
        // 执行加密
        mdTemp.update(strTemp);
        // 加密结果
        byte[] md = mdTemp.digest();
        String result = HexBin.encode(md);
        System.out.println(result);
        String strSub = result.substring(result.length()-3);
        int num = Integer.parseInt(strSub,16);
        int router = num % 1024;
        System.out.println(router);
    }
}
