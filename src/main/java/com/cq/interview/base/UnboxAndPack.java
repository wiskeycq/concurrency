package com.cq.interview.base;

/**
 * @Auther: caoqsq
 * @Date: 2018/7/17 09:18
 * @Description: 拆箱和装箱 https://www.cnblogs.com/dolphin0520/p/3780005.html
 */
public class UnboxAndPack {
    public static void main(String[] args) {
        Integer i = 10;//装箱 实际调用是Integer i = Integer.valueOf(10);
        int n = i;   //拆箱 实际调用时 int n = i.intValue();
        Integer.valueOf(10);
        Double.valueOf(10.0);
        Boolean.valueOf(true);
      /*  因此可以用一句话总结装箱和拆箱的实现过程：
        装箱过程是通过调用包装器的valueOf方法实现的，而拆箱过程是通过调用包装器的 xxxValue方法实现的。（xxx代表对应的基本数据类型）。
        */
    }

    public static void test1() {
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(i1==i2);//true
        System.out.println(i3==i4);//false
        //在通过valueOf方法创建Integer对象的时候，如果数值在[-128,127]之间，便返回指向IntegerCache.cache中已经存在的对象的引用；否则创建一个新的Integer对象。
        //上面的代码中i1和i2的数值为100，因此会直接从cache中取已经存在的对象，所以i1和i2指向的是同一个对象，而i3和i4则是分别指向不同的对象。
    }

    public static void test2() {
        Double i1 = 100.0;
        Double i2 = 100.0;
        Double i3 = 200.0;
        Double i4 = 200.0;
        System.out.println(i1==i2);//false
        System.out.println(i3==i4);//false
        //在这里只解释一下为什么Double类的valueOf方法会采用与Integer类的valueOf方法不同的实现。很简单：在某个范围内的整型数值的个数是有限的，而浮点数却不是。
        //注意，Integer、Short、Byte、Character、Long这几个类的valueOf方法的实现是类似的。范围都是[-128,127]之间都去缓冲区拿，不在则创建新的对象
        //Double、Float的valueOf方法的实现是类似的。
    }

    public static final void test3() {
        Boolean i1 = false;
        Boolean i2 = false;
        Boolean i3 = true;
        Boolean i4 = true;
        System.out.println(i1==i2);//true
        System.out.println(i3==i4);//true
    }

    /*谈谈Integer i = new Integer(xxx)和Integer i =xxx;这两种方式的区别。
    * 1）第一种方式不会触发自动装箱的过程；而第二种方式会触发；
    * 2）在执行效率和资源占用上的区别。第二种方式的执行效率和资源占用在一般性情况下要优于第一种情况（注意这并不是绝对的）。
    * */
}
