package com.github.houbb.leetcode.topics.array;

public class T53_maxSubArray_V4_PrefixSum_Opt {

    public int maxSubArray(int[] nums) {
        final int n = nums.length;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int maxSum = Integer.MIN_VALUE;
        int minPrefixSum = prefixSum[0]; // 一开始是 prefixSum[0] = 0
        for (int j = 0; j < n; j++) {
            // 本身就是从i开始累加一遍
            int currentSum = prefixSum[j+1];

            // 更新累加和最大值
            maxSum = Math.max(maxSum, currentSum - minPrefixSum);

            // 更新前缀和中的最小值
            minPrefixSum = Math.min(minPrefixSum, currentSum);
        }
        return maxSum;
    }


}
