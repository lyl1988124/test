package com;

import com.lyl.work.sensitiveutils.desensitized.DesensitizedUtils;

/**
 
 * <p> Description : TestEncryptUtils
 *
 * @author : liuyuanlong
 * @date : 2022/6/23 13:21
 */
public class EncryptUtilsTest {

    public static void main(String[] args) {
        TestPersonSub testPersonSub = new TestPersonSub();
        testPersonSub.setSubName("subnameaaaaaaa");

        TestPerson person = new TestPerson();
        person.setPersonSub(testPersonSub);
        person.setCertNo("12345678909876541");
        person.setCustName("小妮儿真可爱！");
        System.out.println("脱敏前：" + person);
        String converent2 = DesensitizedUtils.getConverent(person);
        System.out.println("脱敏后：" + converent2);
    }

}
