package com.github.houbb.leetcode.datastruct.array;

public class T51_maxSumSubArray_V4_DP {

    /**
     * 前缀和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        final int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0];

        for(int i = 1; i < n; i++) {
            int num = nums[i];
            dp[i] = Math.max(dp[i-1]+num, num);
        }

        return dp[n-1];
    }


}
