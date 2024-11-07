package com.github.houbb.leetcode.F100T200;

public class T123_BestTimeToBuyAndSellStockIII_V20241105 {


    /**
     * 递归算法，不考虑时间
     *
     * 1. 最多只能做 4 次交易。2次买入，2次卖出
     * 2. 一天最多2种决策：
     *
     * 2.1 不做交易
     * 2.2 做交易：买入/卖出
     *
     * 3. 时间在流逝
     *
     *
     * @param prices 价格数组
     * @return 结果
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        // 最小值
        int min = prices[0];
        int in1_out1_max = 0;
        // 买1卖1买2
        int in1_out1_in2_max = 0;
        for(int i = 0; i < prices.length; i++) {
            // 计算出当前的结果
            maxProfit = Math.max(maxProfit, in1_out1_in2_max+prices[i]);

            min = Math.min(prices[i], min);
            // 第一题的思路，记录最大值
            in1_out1_max = Math.max(prices[i] - min, in1_out1_max);

            // 下一次的操作
            // 去掉当前这一次的金额，准备好对应的金额
            in1_out1_in2_max = Math.max(in1_out1_in2_max, in1_out1_max - prices[i]);
        }

        return maxProfit;
    }

}
