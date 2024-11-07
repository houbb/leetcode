package com.github.houbb.leetcode.F100T200;

public class T121_BestTimeToBuyAndSellStock_V20241105 {

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
        int b1 = -prices[0];
        int s1 = 0;

        for(int i = 0; i < prices.length; i++) {
            // 卖出第一笔 是否卖？
            s1 = Math.max(s1, b1 + prices[i]);
            // 买入第一笔 是否买？
            b1 = Math.max(b1, - prices[i]);
        }

        return s1;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int value = new T121_BestTimeToBuyAndSellStock_V20241105().maxProfit(prices);
        System.out.println(value);
    }

}
