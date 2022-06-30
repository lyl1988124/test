package com.lyl.test.beanUtils;


import java.util.List;

/**

 * <p> Description : CopyTest2.java
 *
 * @author : liuyuanlong
 * @date : 2020/4/26 13:18
 */
public class TestVO{
    private Integer age;
    private String name;

    // ### start 可被 private TestEntity.Inner inner; 替换
    private Inner inner;

    public static class Inner{
        private Integer a;
        public Inner(Integer a){
            this.a = a;
        }

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }
    }
    // ### end 可被 private TestEntity.Inner inner; 替换

//###    private TestEntity.Inner inner;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inner getInner() {
        return inner;
    }

    public void setInner(Inner inner) {
        this.inner = inner;
    }

    @Override
    public String toString() {
        return "TestVO{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", inner=" + inner +
                '}';
    }
}
