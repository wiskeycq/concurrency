package com.cq.interview.algorithm;

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
}
