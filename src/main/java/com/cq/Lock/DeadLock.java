package com.cq.Lock;

/**
 * @author caoqiang
 * @Description:
 * @date 2019/9/3下午8:42
 */
public class DeadLock {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                System.out.println("thread1 is running");
                synchronized (DeadLock.class) {
                    System.out.println("thread1 is block obj1");

                    Thread.sleep(1000);
                    synchronized (Object.class) {
                        System.out.println("thread1 is block ojb2");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("thread2 is running");
                synchronized (Object.class) {
                    System.out.println("thread2 is block obj1");

                    Thread.sleep(1000);
                    synchronized (DeadLock.class) {
                        System.out.println("thread2 is block ojb2");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
