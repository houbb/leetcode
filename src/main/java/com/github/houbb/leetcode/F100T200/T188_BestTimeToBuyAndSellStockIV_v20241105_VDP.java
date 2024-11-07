package com.github.houbb.leetcode.F100T200;

public class T188_BestTimeToBuyAndSellStockIV_v20241105_VDP {

    /**
     * 优化思路：通过 DP 替代掉递归。
     *
     * @param prices 价格数组
     * @return 结果
     */
    public int maxProfit(int k, int[] prices) {
        // k+1 是为了让 k 和 下标相同，-1 也可以。
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        // 初始化买入状态为最小值，表示极小的初始损失
        for (int i = 0; i <= k; i++) {
            buy[i] = -prices[0];
        }

        // for-each 数组本身
        for (int i = 1; i < prices.length; i++) {

            // for-each k 次操作
            for (int j = 1; j <= k; j++) {
                // 卖出第 j 次  不卖 OR  卖出：当前买入+介个
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
                // 买入第 j 次  不买 OR 买入=上一次-当前
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
            }

        }

        return sell[k];
    }

}
