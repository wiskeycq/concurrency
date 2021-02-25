package com.cq.java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author caoqiang
 * @date 2020/3/11上午10:07
 */
public class Test extends AbstractTest {

    @Override
    public void test2() {
        System.out.println("test2");
    }

    @Override
    public void test() {
        System.out.println("222");
    }

    public void test3() {
        super.test();
    }

//    public static void main(String[] args) {
//        new Test().test();
//        new Test().test2();
//        new Test().test3();
//    }
public static void main(String[] args){
//    List<String> list = new ArrayList<String>();
//    list.add("苹果");  //向列表中添加数据
//    list.add("草莓");  //向列表中添加数据
//    list.add("香蕉");  //向列表中添加数据
//    String str = list.remove(0);
//    System.out.println("我不爱吃的水果是:"+str);
//    Iterator it = list.iterator();  //获取集合的Iterator对象
//    System.out.println("爱吃的水果是:");
//    while(it.hasNext()){  //遍历Iterator对象
//        System.out.println(it.next());  //输出Iterator对象中元素
//    }
//    Runtime runtime = Runtime.getRuntime();
//    System.out.println(runtime);

    List<String> list = new ArrayList<String>(1);
    list.add("1");
    list.add("2");
    System.out.println(list);

    long ss = 2365;
    Integer ss1 = (int) ss/100;
    System.out.println(ss1);
}
}
