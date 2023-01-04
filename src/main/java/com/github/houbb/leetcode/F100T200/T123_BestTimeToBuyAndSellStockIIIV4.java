package com.github.houbb.leetcode.F100T200;

import java.util.Arrays;

public class T123_BestTimeToBuyAndSellStockIIIV4 {


    /**
     *
     * 优化思路：通过 DP 替代掉递归。
     *
     * DP 的内存优化。
     *
     * Observation : For any day we just need the answers of the next day (day + 1) => Optimising it further to O(1) space
     *
     * 所以我们并不需要创建一个 dp[days][maxTx] 的数组，只需要一个 dp[2][maxTx] 的即可。
     *
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
     *
     * @param prices 价格数组
     * @return 结果
     */
    public int maxProfit(int[] prices) {
        final int maxTxTime = 4;

        // 只需要保留 2 天，迭代也只依赖 2 天的数据。
        int[][] dp = new int[2][maxTxTime+1];
        return solve(prices, dp, maxTxTime);
    }

    /**
     * 解决
     *
     * 把上一次涉及到 prices 日期的，全部通过 day % 2 替代。
     * @param prices 价格数组
     * @param dp dp
     * @param maxTxTime 最大交易次数
     * @return 结果
     */
    private int solve(int[] prices,
                      int[][] dp,
                      final int maxTxTime) {

        // 迭代，而不是递归。
        // 为什么天数，要从大=》小？
        for(int day = prices.length; day >= 0; day--) {
            // 内部循环交易次数
            for(int txTime = 0; txTime <= maxTxTime; txTime++) {
                int maxProfit = 0;

                // 没有交易 / 第0天，收益默认为 0
                if(txTime == 0
                    || day == prices.length) {
                    maxProfit = 0;
                } else {
                    //1. 策略1，不做交易
                    int profitNoTx = dp[(day+1)%2][txTime];
                    //2. 策略2，进行交易
                    int profitTx = 0;

                    //DP 中最重要的是 DP 的推导公式。
                    // 因为在前面递归的时候，我们使用的是直接 day 往下一步
                    // 换成迭代循环，这里需要把 day 从后往前，这样在计算 dp[day+1] 的时候，才能复用原来的值，不然都是初始化的值 -1
                    if(txTime % 2 == 0) {
                        //2.1 买入，钱-
                        profitTx = -prices[day] + dp[(day+1) % 2][txTime-1];
                    } else {
                        //2.2 卖出，钱+
                        profitTx = prices[day] + dp[(day+1) % 2][txTime-1];
                    }

                    //3. 返回最大的策略结果
                    maxProfit = Math.max(profitNoTx, profitTx);
                }

                // 存储对应的结果
                dp[day % 2][txTime] = maxProfit;
            }
        }

        // 最后一个结果
        return dp[0][maxTxTime];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        int result = new T123_BestTimeToBuyAndSellStockIIIV4().maxProfit(prices);
        System.out.println(result);
    }

}
