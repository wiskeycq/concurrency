package com.cq.interview.algorithm;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: caoqsq
 * @Date: 2018/8/15 11:54
 * @Description:
 */
public class Student {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Student(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) throws Exception{
//        for(int i=0;i<3;i++) {
//            System.out.println("i====="+i);
//            for (int j=1;j<4;j++) {
//                if (i==j) {
//                    throw new Exception("cuowu");
//                }
//            }
//        }
        List<String> actualList = Lists.newArrayList("1","2","3");
        ArrayList<String> expectList = Lists.newArrayList("1","2","3","4");
        if (actualList.containsAll(expectList)) {
            System.out.println(1);
        }
    }
}
