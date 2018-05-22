package com.cq.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: caosq
 * @Date: 2018/05/22 20:36
 * @Description:
 */
@Slf4j
public class ThreadPoolExample4 {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        /*
        //三秒后执行
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                log.info("schedulen run!");
            }
        },3,TimeUnit.SECONDS);
       executorService.shutdown();*/
        //延迟五秒后，每三秒执行一次，轮询执行，所以不需要关闭线程池
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.info("scheduleAtFixedRate run!");
            }
        },5,3,TimeUnit.SECONDS);

        //每两秒执行一次，单线程执行
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("timer run!");
            }
        },new Date(),2*1000);
    }
}
