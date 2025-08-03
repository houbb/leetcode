package com.github.houbb.leetcode.topics.prefixSum;

public class LC704_findPivotIndex_V3_PrefixSumSpaceComparess {


    // 不包含自己
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        //1. 前缀和
        int totalSum = 0;
        for(int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        int leftSum = 0;
        int rightSum = 0;
        for(int i = 0; i < n; i++) {
            // 右边 [i+1,length]
            rightSum = totalSum - leftSum - nums[i];

            // 相等
            if(leftSum == rightSum) {
                return i;
            }

            // 更新 leftSum
            leftSum += nums[i];
        }

        return -1;
    }

}
