package com;

import com.alibaba.fastjson.JSON;
import com.lyl.work.sensitiveutils.sensitiveInfo.JavaBeanA;
import com.lyl.work.sensitiveutils.sensitiveInfo.JavaBeanB;
import com.lyl.work.sensitiveutils.sensitiveInfo.SensitiveInfoUtils;
import org.junit.Test;

import java.util.*;

/**
 
 * <p> Description : adsf
 *
 * @author : liuyuanlong
 * @date : 2022/6/23 15:09
 */
public class SensitiveInfoUtilsTest {

    /**
     * [中文姓名] 只显示第一个汉字，其他隐藏为2个星号<例子：李**>
     */
    @Test
    public void testChineseNameString() {
        System.out.println(SensitiveInfoUtils.chineseName("李先生"));
    }

    /**
     * [中文姓名] 只显示第一个汉字，其他隐藏为2个星号<例子：李**>
     */
    @Test
    public void testChineseNameStringString() {
        System.out.println(SensitiveInfoUtils.chineseName("李","雷"));
    }

    /**
     * [身份证号] 显示最后四位，其他隐藏。共计18位或者15位。<例子：*************5762>
     */
    @Test
    public void testIdCardNum() {
        System.out.println(SensitiveInfoUtils.idCardNum("1103541983073188711"));
    }

    /**
     * [固定电话] 后四位，其他隐藏<例子：****1234>
     */
    @Test
    public void testFixedPhone() {
        System.out.println(SensitiveInfoUtils.fixedPhone("01077482277"));
    }

    /**
     * [手机号码] 前三位，后四位，其他隐藏<例子:138******1234>
     */
    @Test
    public void testMobilePhone() {
        System.out.println(SensitiveInfoUtils.mobilePhone("13777446578"));
    }

    /**
     * [地址] 只显示到地区，不显示详细地址；我们要对个人信息增强保护<例子：北京市海淀区****>
     */
    @Test
    public void testAddress() {
        System.out.println(SensitiveInfoUtils.address("北京朝阳区酒仙桥中路26号院4号楼人人大厦",8));
    }

    /**
     * [电子邮箱] 邮箱前缀仅显示第一个字母，前缀其他隐藏，用星号代替，@及后面的地址显示<例子:g**@163.com>
     */
    @Test
    public void testEmail() {
        System.out.println(SensitiveInfoUtils.email("66374777@qq.com"));
    }

    /**
     * [银行卡号] 前六位，后四位，其他用星号隐藏每位1个星号<例子:6222600**********1234>
     */
    @Test
    public void testBankCard() {
        System.out.println(SensitiveInfoUtils.bankCard("6228480402565890018"));
    }

    /**
     *  [公司开户银行联号] 公司开户银行联行号,显示前两位，其他用星号隐藏，每位1个星号<例子:12********>
     */
    @Test
    public void testCnapsCode() {
        System.out.println(SensitiveInfoUtils.cnapsCode("102100029679"));
    }

    /**
     * 获取脱敏json串 <注意：递归引用会导致java.lang.StackOverflowError>
     */
    @Test
    public void testGetJson() {

        JavaBeanA a1 = new JavaBeanA();
        JavaBeanA a2 = new JavaBeanA();
        JavaBeanB b1 = new JavaBeanB();

        a1 = new JavaBeanA("ADSFASDFASFDSAFD",b1);
  //      a1.setB(b1);
//        a1.setDate(new Date());

        List<JavaBeanB> a1l = new ArrayList<>();
        a1l.add(b1);
        a1.setList(a1l);
        Map<String, JavaBeanB> a1m = new HashMap<>();
        a1m.put("b1", b1);
        a1.setMap(a1m);

        b1.setA(a2);
        Set<JavaBeanA> b1l = new HashSet<JavaBeanA>();
        b1.setList(b1l);
        Map<String, JavaBeanA> b1m = new HashMap<String, JavaBeanA>();
        b1m.put("a2", a2);
        b1.setMap(b1m);
        long t = System.currentTimeMillis();
        System.out.println(t);
        System.out.println(SensitiveInfoUtils.getJson(a1));
        System.out.println(System.currentTimeMillis()-t);
        System.out.println(JSON.toJSON(a1));
        System.out.println(System.currentTimeMillis()-t);
    }
}
