package com.github.houbb.leetcode.F700T800;

public class T713_BestTimeToBuyAndSellStockWithTxFee_V1 {

    public int maxProfit(int[] prices, int fee) {
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i-1] - fee;
            if(profit > 0) {
                maxProfit += profit;
            }
        }

        return maxProfit;
    }

}
