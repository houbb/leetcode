package com.github.houbb.leetcode.datastruct.array;

@Deprecated
public class T51_maxSumSubArray_V1_TwoPointer {

    /**
     * 前缀和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        final int n = nums.length;

        // BF 匹配
        int maxSum = nums[0];
        int left = 0;
        int right = n-1;

        while (left <= right) {

        }

        return maxSum;
    }


}
