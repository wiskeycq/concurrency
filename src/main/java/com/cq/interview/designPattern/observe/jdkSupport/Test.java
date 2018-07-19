package com.cq.interview.designPattern.observe.jdkSupport;

/**
 * @Auther: caoqsq
 * @Date: 2018/7/19 11:29
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        /*try {
            System.out.println(1);
        } catch (Exception e) {

        } finally {
            System.out.println(2);
        }*/
        int m=getInt();
        System.out.println(m);
    }

    public static int getInt() {
        try {
           return 1;
        } catch (Exception e) {

        } finally {
          return 2;
        }
    }
}
