package com.cq.example.commonUnsafe;

import com.cq.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/10 16:42
 * @Description: 这种申明SimpleDateFormat为全局变量的写法是错误的，当多线程运行的时候，由于SimpleDateFormat是线程不
 * 安全的类，所以会报错，当然单线程是正确的，正确的写法请看类SimpleDateFormatExample2
 */
@Slf4j
@NotThreadSafe
public class SimpleDateFormatExample {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    //请求总数
    public static int clientTotal = 5000;
    //同时并发的线程数
    public static int threadTotal = 200;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i=0;i<clientTotal;i++) {
            executorService.execute(()->{
                try {
                    // 从信号量中获取一个允许机会
                    semaphore.acquire();
                    dateFormat();
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
    }

    public static void dateFormat() {
        try {
            Date date =simpleDateFormat.parse("20180510");
            //log.info("解析的日期为：{}",date);
        } catch (ParseException e) {
           log.error("解析异常为：{}",e);
        }
    }
}
