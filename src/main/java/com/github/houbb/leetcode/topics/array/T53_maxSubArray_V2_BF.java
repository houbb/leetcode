package com.github.houbb.leetcode.topics.array;

public class T53_maxSubArray_V2_BF {

    public int maxSubArray(int[] nums) {
        final int n = nums.length;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                // 本身就是从i开始累加一遍
                sum += nums[j];

                if(sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }


}
