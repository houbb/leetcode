package com.github.houbb.leetcode.F100T200;

public class T123_BestTimeToBuyAndSellStockIII_V20241105_VDP {


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
        int b1 = -prices[0];
        int b2 = -prices[0];
        int s1 = 0;
        int s2 = 0;

        for(int i = 0; i < prices.length; i++) {
            // 卖出第二笔 是否卖？
            s2 = Math.max(s2, b2 + prices[i]);
            // 买入第二笔 是否买？
            b2 = Math.max(b2, s1 - prices[i]);
            // 卖出第一笔 是否卖？
            s1 = Math.max(s1, b1 + prices[i]);
            // 买入第一笔 是否买？
            b1 = Math.max(b1, - prices[i]);
        }

        return s2;
    }

}
