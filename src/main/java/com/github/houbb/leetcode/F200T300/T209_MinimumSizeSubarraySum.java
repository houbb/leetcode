package com.github.houbb.leetcode.F200T300;

public class T209_MinimumSizeSubarraySum {

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
        for(int step = 0; step < nums.length; step++) {
            for(int i = 0; i < nums.length - step; i++) {
                if(fitSum(nums, i, i+step, target)) {
                    return step+1;
                }
            }
        }

        return 0;
    }

    private boolean fitSum(int[] nums,
                        int startIndex,
                        int endIndex,
                           int target) {
        int sum = 0;
        for(int i = startIndex; i <= endIndex; i++) {
            sum += nums[i];

            if(sum >= target) {
                return true;
            }
        }

        return false;
    }

}
