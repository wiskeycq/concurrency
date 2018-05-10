package com.cq.example.syncContainer;

import com.cq.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/10 20:41
 * @Description: vector是同步容器
 */
@Slf4j
@NotThreadSafe
public class VectorExample1 {

    private static Vector<Integer> list = new Vector<>();
    //请求总数
    public static int clientTotal = 5000;
    //同时并发的线程数
    public static int threadTotal = 200;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i=0;i<clientTotal;i++) {
            final int count =i;
            executorService.execute(()->{
                try {
                    // 从信号量中获取一个允许机会
                    semaphore.acquire();
                    update(count);
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
        log.info("list的长度为：{}",list.size());
    }

    public static void update(int i) {
        list.add(i);
    }
}
