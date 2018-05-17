
package com.cq.example.lock;

import com.cq.annoations.NotThreadSafe;
import com.cq.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/3 15:06
 * @Description: ReentrantLock 加锁基础使用
 */

@Slf4j
@ThreadSafe
public class LockExample1 {
    //请求总数
    private static int clientTotal = 5000;
    //同时并发的线程数
    private static int threadTotal = 200;
    //计数常量
    private static int count = 0;

    private final static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i=0;i<clientTotal;i++) {
            executorService.execute(()->{
                try {
                    // 从信号量中获取一个允许机会
                    semaphore.acquire();
                    add();
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
        log.info("count:{}",count);
    }

    public static void add() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }//为了防止锁不释放，放在finally保证一定执行
    }
}
