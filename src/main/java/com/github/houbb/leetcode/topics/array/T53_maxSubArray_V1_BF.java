package com.github.houbb.leetcode.topics.array;

public class T53_maxSubArray_V1_BF {

    public int maxSubArray(int[] nums) {
        final int n = nums.length;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                // 求和
                int sum = sum(i, j, nums);
                if(sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    private int sum(int startIx, int endIx, int[] nums) {
        int sum = 0;
        for(int i = startIx; i <= endIx; i++) {
            sum += nums[i];
        }
        return sum;
    }

}
