package com.github.houbb.leetcode.F100T200;

public class T123_BestTimeToBuyAndSellStockIII {


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
        return solve(prices, 0, 4);
    }

    /**
     *
     * @param prices 价格表
     * @param day 第几天
     * @param txTimeLeft 交易次数剩余
     * @return 结果
     */
    private int solve(int[] prices,
                      int day,
                      int txTimeLeft) {
        // 终止条件
        if(day >= prices.length
            || txTimeLeft <= 0) {
            return 0;
        }

        //1. 策略1，不做交易
        int profitNoTx = solve(prices, day+1, txTimeLeft);

        //2. 策略2，进行交易
        int profitTx = 0;

        if(txTimeLeft % 2 == 0) {
            //2.1 买入，钱-
            profitTx = -prices[day] + solve(prices, day + 1, txTimeLeft-1);
        } else {
            //2.2 卖出，钱+
            profitTx = prices[day] + solve(prices, day + 1, txTimeLeft-1);
        }

        //3. 返回最大的策略结果
        return Math.max(profitNoTx, profitTx);
    }



}
