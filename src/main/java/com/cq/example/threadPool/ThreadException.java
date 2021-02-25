package com.cq.example.threadPool;

import com.alibaba.fastjson.JSON;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author caoqiang
 * @date 2020/12/7上午10:49
 */
public class ThreadException {

    public static void main(String[] args){
        ThreadPoolTaskExecutor executor =  buildThreadPoolTaskExecutor();
        System.out.println("执行前"+JSON.toJSONString(executor));
        executor.execute(() -> run("execute方法"));
        try {
            Future task = executor.submit(() -> run("submit方法"));
            task.get();
        } catch (Exception e) {
            System.out.println("线程池执行异常");
        }

        System.out.println("执行后"+JSON.toJSONString(executor));


    }

    private static void run(String name) {
        String printStr = "【thread-name:" + Thread.currentThread().getName() + ",执行方式:" + name+"】";
        System.out.println(printStr);
        throw new RuntimeException(printStr + ",出现异常");
    }

    private static ThreadPoolTaskExecutor buildThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executorService = new ThreadPoolTaskExecutor();
        executorService.setThreadNamePrefix("(cq验证线程池中一个线程抛出异常)-");
        executorService.setCorePoolSize(5);
        executorService.setMaxPoolSize(10);
        executorService.setQueueCapacity(100);
        executorService.setKeepAliveSeconds(10);
        executorService.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executorService.initialize();
        return executorService;
    }
}
