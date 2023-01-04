package com.github.houbb.leetcode.F100T200;

import java.util.Arrays;

public class T123_BestTimeToBuyAndSellStockIIIV2 {


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
     * 优化思路：通过引入内存数组，记录历史结果，避免重复计算。
     *
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
     *
     * @param prices 价格数组
     * @return 结果
     */
    public int maxProfit(int[] prices) {
        // 行：prices.length
        // 列：次数

        int txTimeLeft = 4;

        int[][] mem = new int[prices.length][txTimeLeft+1];
        // 初始化为-1？，还是默认的 0 就可以
        this.fillArrays(mem, -1);

        return solve(prices, 0, txTimeLeft, mem);
    }

    private void fillArrays(int[][] mem, int initVal) {
        int rows = mem.length;
        int cols = mem[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                mem[i][j] = initVal;
            }
        }
    }

    /**
     *
     * @param prices 价格表
     * @param day 第几天
     * @param txTimeLeft 交易次数剩余
     * @param mem 内存
     * @return 结果
     */
    private int solve(int[] prices,
                      int day,
                      int txTimeLeft,
                      int[][] mem) {
        // 终止条件
        if(day >= prices.length
            || txTimeLeft <= 0) {
            return 0;
        }

        // 从历史 mem 的结算结果中，直接获取结果
        int ans = mem[day][txTimeLeft];
        if(ans != -1) {
            return ans;
        }


        //1. 策略1，不做交易
        int profitNoTx = solve(prices, day+1, txTimeLeft, mem);

        //2. 策略2，进行交易
        int profitTx = 0;

        if(txTimeLeft % 2 == 0) {
            //2.1 买入，钱-
            profitTx = -prices[day] + solve(prices, day + 1, txTimeLeft-1, mem);
        } else {
            //2.2 卖出，钱+
            profitTx = prices[day] + solve(prices, day + 1, txTimeLeft-1, mem);
        }

        //3. 返回最大的策略结果
        int maxProfit = Math.max(profitNoTx, profitTx);

        // 返回之前，存储对应的结果
        mem[day][txTimeLeft] = maxProfit;
        return maxProfit;
    }



}
