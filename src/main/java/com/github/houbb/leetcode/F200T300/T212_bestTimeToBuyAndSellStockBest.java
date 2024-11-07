package com.github.houbb.leetcode.F200T300;

public class T212_bestTimeToBuyAndSellStockBest {

    public int maxProfit(int[] prices) {
        int maxResult = 0;
        int minVal = prices[0];
        for(int i = 0; i < prices.length; i++) {
            minVal = Math.min(minVal, prices[i]);
            maxResult = Math.max(prices[i] - minVal, maxResult);
        }

        return maxResult;
    }

}
