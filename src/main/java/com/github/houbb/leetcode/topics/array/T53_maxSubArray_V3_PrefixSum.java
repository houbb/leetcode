package com.github.houbb.leetcode.topics.array;

public class T53_maxSubArray_V3_PrefixSum {

    public int maxSubArray(int[] nums) {
        final int n = nums.length;
        int max = Integer.MIN_VALUE;

        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                // 本身就是从i开始累加一遍
                sum = prefixSum[j+1] - prefixSum[i];

                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }


}
