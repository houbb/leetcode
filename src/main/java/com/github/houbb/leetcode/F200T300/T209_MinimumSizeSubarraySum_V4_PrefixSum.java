package com.github.houbb.leetcode.F200T300;

public class T209_MinimumSizeSubarraySum_V4_PrefixSum {

    /**
     * 使用 slide window 实现
     *
     * 1. step 从 1 到 len
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        // 构建前缀和数组
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        for(int step = 0; step < nums.length; step++) {
            for(int i = 0; i < nums.length - step; i++) {

                int sum = prefixSum[i+step] - prefixSum[i] + nums[i];
                if(sum >= target) {
                    return step+1;
                }
            }
        }

        return 0;
    }

}
