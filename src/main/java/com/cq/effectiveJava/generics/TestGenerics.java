package com.cq.effectiveJava.generics;

/**
 * @author caoqiang
 * @Description:
 * @date 2019/4/4下午2:00
 */
public class TestGenerics {
    public static void main(String[] args) {
        GenClass<Integer> genClass1 = new GenClass<Integer>(1);
        GenClass<String> genClass2 = new GenClass<String>("cc");
        System.out.println(genClass1.getKey());
        System.out.println(genClass2.getKey());
    }
}
