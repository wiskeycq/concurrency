package com.cq.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/16 17:09
 * @Description: CountDownLatch类的基本用法，等待前面的任务都执行玩之后才执行后续的操作
 */
@Slf4j
public class CountDownLatchExample1 {

    private final static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        //创建一个线程池
        ExecutorService executorService=Executors.newCachedThreadPool();//线程池中是不能保证哪个线程先执行的

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        //将200个请求放在线程池中去执行
        for (int i=0;i<threadCount;i++) {
            final int threadNum = i;
            executorService.execute(()-> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    log.error("exception");
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();//如果把这行去掉，就不能保证log.info("finish")是在所有的线程都执行玩才执行的，
        log.info("finish");
        executorService.shutdown();

    }

    private static void test(int theadNum) throws InterruptedException {
        log.info("{}",theadNum);
    }
}
