package com.github.houbb.leetcode.F100T200;

public class T198_HouseRobberV3 {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        // 从1开始，避免 i-1 越界。
        for(int i = 1; i < nums.length; i++) {
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }

        return dp[nums.length];
    }

}
