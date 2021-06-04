package com.cq.example.count;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author caoqiang
 * @date 2021/2/25上午10:59
 */
public class AtomicMain {

    class Count{
        // 共享变量
        private LongAdder count = new LongAdder();
        public Long getCount() {
            return count.sum();
        }
        //也可以加synchronized解决线程不安全的问题
        public  void increase() {
            count.increment();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();

        Count count = new AtomicMain().new Count();
        // 100个线程对共享变量进行加1
        for (int i = 0; i < 1000000; i++) {
            service.execute(() -> count.increase());
        }

        // 等待上述的线程执行完
        service.shutdownNow();
        service.awaitTermination(1, TimeUnit.DAYS);

        ThreadPoolExecutor threadPoolExecutor = ((ThreadPoolExecutor) service);
        System.out.println("当前排队线程数：" + threadPoolExecutor.getQueue().size());
        System.out.println("当前活动线程数：" + threadPoolExecutor.getActiveCount());
        System.out.println("执行完成线程数：" + threadPoolExecutor.getCompletedTaskCount());
        System.out.println("总线程数：" + threadPoolExecutor.getTaskCount());



        System.out.println(count.getCount());
    }
}
