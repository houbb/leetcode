package com.github.houbb.leetcode.F200T300;

public class T212_bestTimeToBuyAndSellStock {

    /**
     * 最简单的暴力算法
     * @param prices 价格
     * @return 结果
     */
    public int maxProfit(int[] prices) {
        int maxResult = 0;

        for(int i = 0; i < prices.length-1; i++) {
            for(int j = i+1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxResult =  Math.max(profit, maxResult);
            }
        }

        return maxResult;
    }

}
