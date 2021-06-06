package com.cq.interview.algorithm.finalTest;

/**
 * @author caoqiang
 * @date 2021/6/6下午4:09
 *
 * 排列硬币，第一行放一个，第二行放两个，第三行放三个，依次类推，返回放了几列；如果输入5，返回的是2，因为，1，2，3，第三列不够了
 */
public class ArrangeCoin {
    public static void main(String[] args) {
        System.out.println(arrangeCoin(7));
    }

    public static int arrangeCoin(int n) {
        for (int i=1;i<=n;i++) {
            n=n-i;
            if (n<=i) {
                return i;
            }
        }
        return 0;
    }
}
