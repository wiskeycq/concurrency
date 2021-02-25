package com.cq.Lock;

/**
 * @author caoqiang
 * @Description:
 * @date 2019/9/3下午8:00
 */
public class DeadLockDemo {

    /**
     * 此方法请求两个锁,第一个字符串,然后整数
     */
    public static void method1() {
        synchronized (String.class) {
            System.out.println("Aquired lock on String.class object");

            synchronized (Integer.class) {
                System.out.println("Aquired lock on Integer.class object");
                method2();
            }
        }
    }


    /**
     * 此方法也请求相同的两个锁,但完全
     * 相反的顺序,即首先整数,然后字符串。
     * 如果一个线程持有字符串锁,则这会产生潜在的死锁
     * 和其他持有整数锁,他们等待对方,永远。
     */
    public static void method2() {
        synchronized (Integer.class) {
            System.out.println("Aquired lock on Integer.class object2");

            synchronized (String.class) {
                System.out.println("Aquired lock on String.class object2");
            }
        }
    }

    public static void main(String[] args) {
        method1();
       // method2();
    }
}
