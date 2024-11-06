package com.github.houbb.leetcode.F700T800;

public class F713_bestTimeToBuyAndSellStockWithTransactionFee_DP {


    public int maxProfit(int[] prices, int fee) {
        int buy[] = new int[prices.length];
        int sell[] = new int[prices.length];

        buy[0] = -prices[0];

        // 遍历
        for(int i = 1; i < prices.length; i++) {
            //卖出 不卖出？ 卖出 = buy[i-1] + prices[i] - FEE
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i] - fee);

            // 卖出 不卖出？ 卖出 = sell[i-1] - prices[i]
            buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i]);
        }

        return sell[prices.length-1];
    }

}
