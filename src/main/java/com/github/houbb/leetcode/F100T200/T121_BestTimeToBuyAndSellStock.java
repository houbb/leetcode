package com.github.houbb.leetcode.F100T200;

public class T121_BestTimeToBuyAndSellStock {

    /**
     * 思虑
     *
     * 1. 从第一天作为买入，和后面的每一天进行对比
     * 2. 获取出最大的差值
     *
     * PS：这个方法本身也许没有问题，但是性能为 O(n^2)，会超时。
     *
     * @param prices 价格数组
     * @return 结果
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        // 最后一天买没有意义
        for(int i = 0; i < prices.length-1; i++) {
            for(int j = i+1; j < prices.length; j++) {
                // 较低的价格买入，较高的价格卖出
                int profit = prices[j] - prices[i];

                if(profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int value = new T121_BestTimeToBuyAndSellStock().maxProfit(prices);
        System.out.println(value);
    }

}
