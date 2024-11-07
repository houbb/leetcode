package com.github.houbb.leetcode.F300T400;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T309_bestTimeToBuyAndSellStockWithCooldownV2_Dp {


    /**
     * ### a1
     *
     * a1 什么时候手上会有股票? 必须是买入的时候。
     *
     * 一种是上次就持有；还有一种处于 a3 状态，然后买入。
     *
     * ```java
     * a1[i] = max(a1[i-1], a3[i-1] - prices[i]);
     * ```
     *
     * ### a2
     *
     * a2: 手上不持有股票，并且处于冷冻期中的累计最大收益
     *
     * 什么场景会不持有，则处于冷冻期？
     *
     * 就是持有股票，然后直接卖出了？
     *
     * ```java
     * a2[i] = a1[i-1] + prices[0];
     * ```
     *
     * ### a3
     *
     * a3: 手上不持有股票，并且不在冷冻期中的累计最大收益
     *
     * 什么场景不持有股票，且不处于冷冻期。
     *
     * 1）此时不能直接卖出，因为会被冷冻；所以
     *
     * 2）昨天分为两个场景：a2 状态；或者 a3 状态
     *
     * ```java
     * a3[i] = max(a3[i-1], a2[i-1])
     * ```
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // a1: 手上持有股票的最大收益   主要是为了计算存储，结果不考虑此场景。
        // a2: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // a3: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int a1[] = new int[n];
        int a2[] = new int[n];
        int a3[] = new int[n];

        // 初始化
        a1[0] = -prices[0];

        for (int i = 1; i < n; ++i) {
            // 持有股票：昨天持有 OR 买入
            a1[i] = Math.max(a1[i-1], a3[i-1] - prices[i]);

            // 手上不持有股票，并且处于冷冻期中的累计最大收益: 必定是卖出
            a2[i] = a1[i-1] + prices[i];

            // 手上不持有股票，并且不在冷冻期中的累计最大收益:  昨天可能是 a3; a2
            a3[i] = Math.max(a2[i-1], a3[i-1]);
        }

        // 手里没有股票对比即可
        return Math.max(a2[n-1], a3[n-1]);
    }


}
