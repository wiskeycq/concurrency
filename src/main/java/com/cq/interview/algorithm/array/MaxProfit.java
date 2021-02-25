package com.cq.interview.algorithm.array;

/**
 * @author caoqiang
 * @date 2020/12/18下午2:36
 */
public class MaxProfit {

    /**
     * 股票交易一次最大利润
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxValue = 0;
        for (int price : prices) {
            if(price > min) {
                maxValue = Math.max(maxValue, price - min);
            } else {
                min = price;
            }
        }
        return maxValue;
    }

    /**
     * 股票交易多次最大利润
     *
     * @param prices
     * @return
     */
    public static int repeatMaxProfit(int[] prices) {
        int ans=0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i]>prices[i-1]) {
                ans+=prices[i]-prices[i-1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println(prices.length);
        System.out.println("最大利润="+repeatMaxProfit(prices));
    }
}
