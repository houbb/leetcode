package com.github.houbb.leetcode.F300T400;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T377_CombinationSumIVV4 {

    /**
     * dp
     *
     * 82%
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;

        for(int i = 1; i <= target; i++) {
            // 处理逻辑
            for(int num : nums) {
                if(num <= i) {
                    dp[i] += dp[i-num];
                }
            }
        }

        return dp[target];
    }

}
