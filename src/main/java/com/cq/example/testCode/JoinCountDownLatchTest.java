package com.cq.example.testCode;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: caosq
 * @Date: 2018/05/12 09:57
 * @Description:
 */
@Slf4j
public class JoinCountDownLatchTest {

    private static Thread mainThread = new Thread();

    public static void main(String[] args) throws InterruptedException {

        //也是匿名内部类的写法，只是这个是一个类比如 A implement Runnable的写法，调用Runnable的run()方法，简化写法
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("thread1");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("thread2");
            }
        });

        // java8 lambda表达式的写法
        Thread thread3 = new Thread(()->{
            log.info("thread3");
        });
        thread1.start();
        //thread1.join();
        thread2.start();
        //thread2.join();
        thread3.start();
        //thread3.join();
    }
}
