package com.cq.example.threadLocal;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/10 13:53
 * @Description:
 */
public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id) {
        requestHolder.set(id);//设置当前线程的线程局部变量的值。
    }

    public static Long getId() {
        return requestHolder.get();//该方法返回当前线程所对应的线程局部变量。
    }

    public static void remove() {
        requestHolder.remove();//将当前线程局部变量的值删除，目的是为了减少内存的占用，该方法是JDK 5.0新增的方法。需要指出的是，当线程结束后，对应该线程的局部变量将自动被垃圾回收，所以显式调用该方法清除线程的局部变量并不是必须的操作，但它可以加快内存回收的速度。
    }

    public static void main(String[] args) {
////        Long ss = RequestHolder.getId();
//        Thread thread = new Thread();
//        thread.start();
//        thread.run();
//        //Thread.sleep(100);
//        System.out.println(ss);
        Integer a=3;
        if (a == 1) {
            System.out.println("111");
        } else if (a<=1) {
            System.out.println("222");
        } else {
            System.out.println("333");
        }
    }
}
