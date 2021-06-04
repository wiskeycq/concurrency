package com.cq.limitFlow;

import com.cq.effectiveJava.test.DateTimeUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author caoqiang
 * @date 2021/3/9下午3:31
 */
public class SemaphoreLimitFlow {

    private static Semaphore semaphore = new Semaphore(3);

    private static String[] userName = {"甄姬", "鲁班", "妲己", "亚瑟"};

    private static Random random = new Random();

    private static AtomicInteger count = new AtomicInteger();

    public void enter(User user){
        try{
            semaphore.acquire();
            if(Thread.interrupted()){
                return;
            }
            System.out.println("时间:" + DateTimeUtil.getCurrentTimeString() +"-"+count.incrementAndGet()+"-"+"       "+user.getName() + "上厕所");
            Thread.sleep(2000);
        }catch (InterruptedException ex){

        }finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        SemaphoreLimitFlow semaphoreLimitFlow = new SemaphoreLimitFlow();

        for(int i = 0; i < 20; i++){
            executorService.submit(()->{
                semaphoreLimitFlow.enter(new User(userName[random.nextInt(4)]));
            });
        }

        executorService.shutdown();
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class User {
        String name;
    }
}
