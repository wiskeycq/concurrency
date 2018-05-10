package com.cq.example.commonUnsafe;

import com.cq.annoations.NotThreadSafe;
import com.cq.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/10 15:16
 * @Description: 证明StringBuffer是线程安全的，那什么时候用stringBuilder呢，如果把stringBuilder声明在方法里面，成为
 * 局部变量的时候，考虑到局部变量有栈封闭的特性，此时用stringBuilder更好，因为stringBuilder效率高，并且线程安全
 */
@Slf4j
@ThreadSafe
public class StringBufferExample {
    //请求总数
    public static int clientTotal = 5000;
    //同时并发的线程数
    public static int threadTotal = 200;
    //计数常量
    public static  StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i=0;i<clientTotal;i++) {
            executorService.execute(()->{
                try {
                    // 从信号量中获取一个允许机会
                    semaphore.acquire();
                    update();
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
        log.info("size:{}",stringBuffer.length());
    }

    public static void update() {
        stringBuffer.append("1");
    }
}
