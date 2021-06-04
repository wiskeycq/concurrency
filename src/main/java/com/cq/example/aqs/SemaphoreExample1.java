package com.cq.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/16 17:09
 * @Description: Semaphore的用法，可以通过打印出日志的时间了解Semaphore的具体用法
 */
@Slf4j
public class SemaphoreExample1 {

    private final static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        //创建一个线程池
        ExecutorService executorService=Executors.newCachedThreadPool();//线程池中是不能保证哪个线程先执行的

        final Semaphore semaphore = new Semaphore(threadCount);

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        //将200个请求放在线程池中去执行
        for (int i=0;i<threadCount;i++) {
            final int threadNum = i;
            executorService.execute(()-> {
                try {
//                    semaphore.acquire();//获取一个许可
//                    semaphore.tryAcquire(2, 30, TimeUnit.SECONDS);
                    if (semaphore.tryAcquire(1)) {
                        test(threadNum);
                    }

                    semaphore.release();//释放一个许可
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
        Thread.sleep(1000);
    }
}
