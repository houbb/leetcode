package com.github.houbb.leetcode.F200T300;

public class T209_MinimumSizeSubarraySumV3 {

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
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (end < nums.length) {
            while (end < nums.length && sum < s) {
                sum += nums[end++];
            }
            if (sum < s) {
                break;
            }
            while (start < end && sum >= s) {
                sum -= nums[start++];
            }
            if (end - start + 1 < minLen) {
                minLen = end - start + 1;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
