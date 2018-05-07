package com.cq.example.atomic;

import com.cq.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Auther: caoqsq
 * @Date: 2018/5/4 09:22
 * @Description:
 */
@Slf4j
@ThreadSafe
public class AtomicIntegerFieldUpdaterExample {

    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterExample> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterExample.class,"count");

    @Getter
    public volatile int count =100;

    private static AtomicIntegerFieldUpdaterExample example = new AtomicIntegerFieldUpdaterExample();//这个也可以放在main方法中

    public static void main(String[] args) {
        //AtomicIntegerFieldUpdaterExample example = new AtomicIntegerFieldUpdaterExample();
        if (updater.compareAndSet(example,100,120)) {
            log.info("update success 1,{}",example.getCount());
        }

        if (updater.compareAndSet(example,100,120)) {
            log.info("update success 2,{}",example.getCount());
        } else {
            log.error("update error,{}",example.getCount());
        }
    }

    /*注意：非静态方法既可以访问静态数据成员 又可以访问非静态数据成员，而静态方法只能访问静态数据成员；
非静态方法既可以访问静态方法又可以访问非静态方法，而静态方法只能访问静态数据方法。 */
    /*原因：因为静态方法和静态数据成员会随着类的定义而被分配和装载入内存中，而非静态方法和非静态数据成员只有在类的对象创建时在对象的内存中才有这个方法的代码段。
    * 静态不能引用非静态这一特性，是由于静态的会随着类的定义而被分配和装载入内存中这一关键点决定的；如果静态引用了非静态的，根本无法从内存中找到非静态的代码段，势必会出错，这种做法是Java虚拟机决不允许的。*/

}
