package com.github.houbb.leetcode.F100T200;

public class T122_BestTimeToBuyAndSellStockII {

    /**
     * because this question allow day trade (same day sell and buy), so this question actually can be solved in this greedy-like solution.
     *
     * Imagine if you're buying and selling stocks and somehow you know the price in advance, what will you do?
     *
     * Whenever you know it's going to be increasing, you buy it today and sell it tommorrow, and in the next day if you know it's keep increasing,
     * buy it back and sell it the next day.
     *
     * If in the next day you know it's going to decrease, simply skip the day(not buying any stock),
     * and whenever it's going to rise again(because you know in advance) you buy it back and sell it in next day.
     *
     * That's how you make money in real life market
     *
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solutions/208241/explanation-for-the-dummy-like-me/
     *
     * 简而言之：你能够预知未来了。如何利益最大化？
     *
     * 1.明天涨。那就今天买入，明天卖掉。
     * 2.明天跌。那就不买入，OR 出售掉（当天买入卖出，并不影响整体的利润。这里没有 FEE）。
     *
     * 这样就是整体的利益最大化，这是贪心算法。
     */

    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++) {
            // 这样性能，看起来比 Math.max 要好一些。
            int profit = prices[i] - prices[i-1];
            if(profit > 0) {
                maxProfit += profit;
            }
        }

        return maxProfit;
    }


}
