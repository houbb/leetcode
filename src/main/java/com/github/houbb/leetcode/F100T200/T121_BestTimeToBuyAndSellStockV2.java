package com.github.houbb.leetcode.F100T200;

public class T121_BestTimeToBuyAndSellStockV2 {

    /**
     * 思虑
     *
     * 1. 从第一天作为买入，和后面的每一天进行对比
     * 2. 获取出最大的差值
     * 问题：问题出现在重复计算。
     *
     *
     * 其实一种比较自然的算法是双指针。
     *
     * L R，时间复杂度为 O(N)
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solutions/1735550/python-javascript-easy-solution-with-very-clear-explanation/
     *
     * @param prices 价格数组
     * @return 结果
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        // 最小的价格
        int minPrice = prices[0];

        for(int price : prices) {
            // 最小的价格，这个为什么可以全局最优呢？
            minPrice = Math.min(price, minPrice);

            maxProfit = Math.max(maxProfit, price-minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int value = new T121_BestTimeToBuyAndSellStockV2().maxProfit(prices);
        System.out.println(value);
    }

}
