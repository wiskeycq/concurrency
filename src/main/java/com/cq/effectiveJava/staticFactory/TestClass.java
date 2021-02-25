package com.cq.effectiveJava.staticFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author caoqiang
 * @Description:
 * @date 2019/3/27下午2:58
 */
public class TestClass implements TestInterface {
    @Override
    public String function1() {
        return null;
    }

    @Override
    public String function2() {
        return null;
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();

        System.out.println(testClass.function3());
        System.out.println(TestInterface.function4());
        System.out.println(TestInterface.name);
        System.out.println(TestClass.name2);

        System.out.println(new TestConstrutor.Person().fun());//静态内部类调用

        int i = new TestConstrutor().new Son().fun(); //非静态内部类调用
        System.out.println(i);

    }
}
