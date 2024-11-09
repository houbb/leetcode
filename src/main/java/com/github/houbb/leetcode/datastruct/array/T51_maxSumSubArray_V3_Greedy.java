package com.github.houbb.leetcode.datastruct.array;

public class T51_maxSumSubArray_V3_Greedy {

    /**
     * 前缀和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        final int n = nums.length;

        // BF 匹配
        int maxSum = nums[0];
        int tempSum = nums[0];
        for(int i = 1; i < n; i++) {
            int num = nums[i];

            // 历史数据大于等于0，则保留继续累加
            if(tempSum >= 0) {
                tempSum += num;
            } else {
                // 历史和小于 0，直接舍弃。只保留今天
                tempSum = num;
            }

            maxSum = Math.max(maxSum, tempSum);
        }

        return maxSum;
    }


}
