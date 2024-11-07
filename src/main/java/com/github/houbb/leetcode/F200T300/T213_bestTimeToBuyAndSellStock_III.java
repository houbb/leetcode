package com.github.houbb.leetcode.F200T300;

public class T213_bestTimeToBuyAndSellStock_III {

    /**
     * 最简单的暴力算法
     * @param prices 价格
     * @return 结果
     */
    public int maxProfit(int[] prices) {
        int maxResult = 0;
        int minVal = prices[0];
        int maxVal = prices[0];
        for(int i = 1; i < prices.length; i++) {
            int cur = prices[i];
            // 值大于当前值
            if(cur > maxVal) {
                maxResult = Math.max(maxResult, cur - minVal);
            }
            // 重置
            if(cur < minVal) {
                minVal = cur;
                maxVal = cur;
            }
        }

        return maxResult;
    }

}
