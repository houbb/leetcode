package com.github.houbb.leetcode.topics.array;

public class T53_maxSubArray_V5_Dp {

    public int maxSubArray(int[] nums) {
        final int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);

            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }


}
