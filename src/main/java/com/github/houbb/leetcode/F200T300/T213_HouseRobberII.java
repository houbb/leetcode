package com.github.houbb.leetcode.F200T300;

import java.util.Arrays;

public class T213_HouseRobberII {


    public int rob(int[] nums) {
        // TODO:///

        //rob0，从 2...-1 开始
        int sum1 = nums[0] + robNoCircle(Arrays.copyOfRange(nums, 2, nums.length-2));

        //not rob0
        int sum2 = robNoCircle(Arrays.copyOfRange(nums, 1, nums.length-1));

        return Math.max(sum1, sum2);
    }


    // 无环时
    public int robNoCircle(int[] nums) {
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
