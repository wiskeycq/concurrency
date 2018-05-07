package com.cq.example.atomic;

import com.cq.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/4 10:08
 * @Description:
 */
@Slf4j
@ThreadSafe
public class AtomicBooleanExample {

    //请求总数
    public static int clientTotal = 5000;
    //同时并发的线程数
    public static int threadTotal = 200;

    private static AtomicBoolean isHappend = new AtomicBoolean(false);

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i=0;i<clientTotal;i++) {
            executorService.execute(()->{
                try {
                    // 从信号量中获取一个允许机会
                    semaphore.acquire();
                   test();
                    // 释放允许，将占有的信号量归还
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception",e);
                }
                // 计数器减1
                countDownLatch.countDown();
            });
        }
        // 当计数器减为0的时候，恢复主线程的执行，打印出计数日志
        countDownLatch.await();
        //线程池执行完释放线程池
        executorService.shutdown();
        log.info("isHappend:{}",isHappend.get());
    }

    public static void test() {
        if (isHappend.compareAndSet(false,true)) {
            log.info("execute");
        }
    }
}
