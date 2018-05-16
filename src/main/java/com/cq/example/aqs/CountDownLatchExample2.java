package com.cq.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/16 17:09
 * @Description: CountDownLatch加时间的参数，意思是等到这个时间后后面的操作就可以执行了
 */
@Slf4j
public class CountDownLatchExample2 {

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

        countDownLatch.await(10,TimeUnit.MILLISECONDS);//10毫秒后执行下面的任务
        log.info("finish");
        executorService.shutdown();//执行到此句并不是将所有的线程都销毁掉，而是等已分配的线程都执行完，才把线程池销毁掉

    }

    private static void test(int theadNum) throws InterruptedException {
        Thread.sleep(1);
        log.info("{}",theadNum);
    }
}
