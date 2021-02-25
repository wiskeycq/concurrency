package com.cq.effectiveJava.staticFactory;

/**
 * @author caoqiang
 * @Description:
 * @date 2019/3/27下午2:47
 */
public interface TestInterface {

    public static final String name ="张三"; //接口中常量默认是public static final

    String name2 ="张三";

    public abstract String function1(); //接口中方法默认是public abstract

    String function2();

    //Java8 允许接口有默认的方法
    default String function3 () {
        return "李四";
    }

    //java8 允许接口定义静态方法
    static String function4() {
        return "王五";
    }
}
