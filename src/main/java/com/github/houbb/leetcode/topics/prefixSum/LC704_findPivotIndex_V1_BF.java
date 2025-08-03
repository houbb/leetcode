package com.github.houbb.leetcode.topics.prefixSum;

public class LC704_findPivotIndex_V1_BF {


    // 不包含自己
    public int pivotIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            // 左边
            long leftSum = 0;
            for(int j = 0; j < i; j++) {
                leftSum += nums[j];
            }

            long rightSum = 0;
            for(int j = i+1; j < nums.length; j++) {
                rightSum += nums[j];
            }
            // 右边
            if(leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

}
