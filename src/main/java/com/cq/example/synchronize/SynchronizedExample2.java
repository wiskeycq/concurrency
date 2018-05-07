package com.cq.example.synchronize;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/4 10:48
 * @Description: 演示synchronized修饰类和静态方法
 */
@Slf4j
public class SynchronizedExample2 {

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            example1.test1(1);
        });
/*        executorService.execute(()->{
            example1.test1();
        });*/
        executorService.execute(()->{
            example2.test1(2);
        });
    }

    //synchronized关键字修饰一个类，作用于所有对象
    private static void test1(int j) {
        synchronized (SynchronizedExample2.class) {
            for (int i=0;i<10;i++) {
                log.info("test1 - {} - {}",j,i);
            }
        }
    }

    //synchronized关键字修饰静态方法，作用于所有对象
    private synchronized static void test2(int j) {
        for (int i=0;i<10;i++) {
            log.info("test2 - {} - {}",j,i);
        }
    }
    //如果子类调用父类的被synchronized修饰的方法时，如果想同步必须子类的方法自己被synchronized修饰，不然的话是不会是
    //同步方法的，因为synchronized不是方法申明的一部分
}
