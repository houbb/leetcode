package com.github.houbb.leetcode.F100T200;

public class T122_BestTimeToBuyAndSellStockII_DP {

    /**
     * DP 思路
     */

    public int maxProfit(int[] prices) {
        int buy[] = new int[prices.length];
        int sell[] = new int[prices.length];

        buy[0] = -prices[0];

        for(int i = 1; i < prices.length; i++) {
            // 是否卖出？  不卖； 卖出=上一次买入 + 当前价格
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);

            // 是否买？   不买； 买入=上一次卖出-当前价格
            buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i]);
        }

        return sell[prices.length-1];
    }


}
