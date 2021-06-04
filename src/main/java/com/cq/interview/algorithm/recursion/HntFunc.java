package com.cq.interview.algorithm.recursion;

/**
 * @author caoqiang
 * @date 2021/3/11下午3:52
 *
 * 存在A、B、C大小形同的3根石柱，其中A石柱从下往上按照大小顺序依次摆放着n个盘子，现在需要将A石柱的盘子全部移动到C石柱上，
 * 并且每次只能移动一个圆盘，小圆盘不能放在大圆盘上，请问该如何移动？
 *
 * https://blog.csdn.net/weixin_39471249/article/details/80067697
 *
 * 算法2的n次方-1
 */
public class HntFunc {

    public static  int count = 0;

    public static void hanoi(int n, String a, String b,String c) {
        if (n == 1) {
            // 只有一个圆盘时直接从A石柱移动到C石柱
            move(n, a, c);

        } else {
            // 将前n-1个圆盘从石柱A移动到石柱B
            hanoi(n - 1, a, c, b);
            // 将第n号圆盘从石柱A移动到石柱C
            move(n, a, c);
            // 将前n-1个圆盘从石柱B移动到石柱C
            hanoi(n - 1, b, a, c);
        }
        System.out.println(count);
    }

    public static void move(int n, String i, String j) {
        count ++;
        System.out.println("第" + n + "个圆盘，" + "从" + i + "移动到" + j);
    }

    public static void main(String[] args) {
        hanoi(10,"A","B","C");
    }
}
