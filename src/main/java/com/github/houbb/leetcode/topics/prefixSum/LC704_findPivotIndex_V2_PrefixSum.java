package com.github.houbb.leetcode.topics.prefixSum;

public class LC704_findPivotIndex_V2_PrefixSum {


    // 不包含自己
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        //1. 前缀和
        int[] prefixSum = new int[n+1];
        for(int i = 0; i < n; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        for(int i = 0; i < n; i++) {
            // 左边 [0,i-1]
            long leftSum = prefixSum[i]-prefixSum[0];

            // 右边 [i+1,length]
            long rightSum = prefixSum[n]-prefixSum[i+1];

            // 相等
            if(leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

}
