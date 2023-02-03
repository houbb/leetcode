package com.github.houbb.leetcode.F200T300;

import java.util.Map;

public class T209_MinimumSizeSubarraySumV2 {

    /**
     * 使用 slide window 实现
     *
     * 1. step 从 1 到 len
     *
     * 添加缓存，依然超时
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        // 缓存，因为步长最短。
        Integer[][] cache = new Integer[nums.length][nums.length];

        for(int step = 0; step < nums.length; step++) {
            for(int i = 0; i < nums.length - step; i++) {
                int sum = calcSum(nums, i, i+step, cache);
                if(sum >= target) {
                    return step+1;
                }
            }
        }

        return 0;
    }

    private int calcSum(int[] nums,
                        int startIndex,
                        int endIndex,
                        Integer[][] cache) {
        int sumCache = 0;
        if(endIndex > 0) {
            Integer val = cache[startIndex][endIndex-1];
            if(val != null) {
                sumCache = val;
            }
            // 其他为0
        }

        int sum = sumCache + nums[endIndex];
        cache[startIndex][endIndex] = sum;
        return sum;
    }

}
