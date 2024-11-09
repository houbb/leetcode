package com.github.houbb.leetcode.datastruct.array;

public class T51_maxSumSubArray_V1_PrefixSum {

    /**
     * 前缀和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        final int n = nums.length;

        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        // BF 匹配
        int maxSum = nums[0];
        for(int i = 0; i < n; i++) {
            // 后面的数组 》 前一个标识
            for(int j = i; j < n; j++) {
                int sum = prefixSum[j] - prefixSum[i] + nums[i];

                // 更新最大值
                 maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }


}
