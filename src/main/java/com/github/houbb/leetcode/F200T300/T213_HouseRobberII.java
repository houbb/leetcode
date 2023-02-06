package com.github.houbb.leetcode.F200T300;

public class T213_HouseRobberII {


    public int rob(int[] nums) {
        //rob0，从 2...-1 开始
        int sum1 = nums[0] + robNoCircle(getSubArray(nums, 2, nums.length-2));

        //not rob0
        int sum2 = robNoCircle(getSubArray(nums, 1, nums.length-1));

        return Math.max(sum1, sum2);
    }

    private int[] getSubArray(int[] nums,
                              int startIndex,
                              int endIndex) {
        if(endIndex < startIndex) {
            return new int[0];
        }

        int len = endIndex - startIndex + 1;
        int[] results = new int[len];
        int size = 0;
        for(int i = startIndex; i <= endIndex; i++) {
            results[size++] = nums[i];
        }
        return results;
    }

    // 无环时
    public int robNoCircle(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

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
