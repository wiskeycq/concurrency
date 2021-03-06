package com.cq.example.commonUnsafe;

import com.cq.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/10 20:41
 * @Description: ArrayList是线程不安全的，一般定义在方法里面成为局部变量，不要定义全局成为共享变量
 */
@Slf4j
@NotThreadSafe
public class ArrayListExample {

    private static List<Integer> list = new ArrayList<>();
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
        //countDownLatch可以保证所有的请求都处理完在执行需要的操作
        countDownLatch.await();
        //线程池执行完释放线程池
        executorService.shutdown();
        log.info("list的长度为：{}",list.size());
        for(int i=0;i<list.size();i++) {
            log.info("list的值分别为：{}",list.get(i));
        }
    }

    public static void update(int i) {
        list.add(i);
    }
}
