package com.github.houbb.leetcode.topics.array;

public class T53_maxSubArray_V5_DpOpt {

    public int maxSubArray(int[] nums) {
        final int n = nums.length;

        int dp = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < n; i++) {
            dp = Math.max(nums[i], dp+nums[i]);

            maxSum = Math.max(maxSum, dp);
        }
        return maxSum;
    }


}
