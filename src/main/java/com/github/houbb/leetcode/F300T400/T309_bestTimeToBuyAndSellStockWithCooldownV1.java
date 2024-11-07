package com.github.houbb.leetcode.F300T400;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T309_bestTimeToBuyAndSellStockWithCooldownV1 {


    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];

        for (int i = 1; i < n; i ++) {
            if (prices[i] <= prices[i-1]) {
                dp[i] = dp[i-1];
                continue;
            }
            if (i < 2) {
                dp[i] = prices[1] - prices[0];
            } else {
                dp[i] = Math.max(dp[i-1], dp[i-2] + prices[i] - prices[i-1]);
            }
        }

        return dp[n-1];
    }
    

}
