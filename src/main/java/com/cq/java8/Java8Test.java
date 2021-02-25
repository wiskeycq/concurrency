package com.cq.java8;



import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/17 15:43
 * @Description:  java8 lambda表达式的一些写法;https://blog.csdn.net/bitcarmanlee/article/details/70195403
 */
public class Java8Test {

    public static void iterTest1() {
        List<String> languages = Arrays.asList("java","scala","python");
        //before java8
        for(String each:languages) {
            System.out.println(each);
        }
    }
    public static void iterTest2() {
        List<String> languages = Arrays.asList("java","scala","python");
        //languages.add("C");
        //after java8
       languages.forEach(x -> System.out.println(x));
       //languages.forEach(System.out::println);
    }

    //map函数可以说是函数式编程里最重要的一个方法了。map的作用是将一个对象变换为另外一个。在我们的例子中，就是通过map方法将cost增加了0,05倍的大小然后输出。
    public static void mapTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        cost.stream().map(x -> x + x*0.05).forEach(x -> System.out.println(x));
    }

    // reduce与map一样，也是函数式编程里最重要的几个方法之一。。。map的作用是将一个对象变为另外一个，而reduce实现的则是将所有值合并为一个
    public static void mapReduceTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        //double allCost = cost.stream().map(x -> x+x*0.05).reduce((sum,x) -> sum + x).get();
        double allCost = cost.stream().map(x -> x+x*0.05).reduce((sum,x) -> sum).get();
        System.out.println(allCost);
    }

    //filter也是我们经常使用的一个操作。在操作集合的时候，经常需要从原始的集合中过滤掉一部分元素。
    public static void filterTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0,40.0);
        List<Double> filteredCost = cost.stream().filter(x -> x > 25.0).collect(Collectors.toList());
        filteredCost.forEach(x -> System.out.println(x));
    }

    public static void filterTest(List<String> languages, Predicate<String> condition) {
        languages.stream().filter(x -> condition.test(x)).forEach(x -> System.out.println(x + " "));
    }

    public static void main(String[] args) throws Exception{
        long statTime = System.currentTimeMillis();

        ExecutorService e = Executors.newFixedThreadPool(4);

        e.execute(new Runnable() {
            @Override
            public void run() {

                List<String> list = new LinkedList<String>();
                for (int i = 0; i<1000000; i++) {
                    list.add("cq");
                }
                for (int i=0; i<list.size(); i++) {
                    //Thread.sleep(100);
                    list.get(i);
                }
            }
        });
        long endTime = System.currentTimeMillis();
        System.out.println("cost time:"+(endTime-statTime));
    }
}

