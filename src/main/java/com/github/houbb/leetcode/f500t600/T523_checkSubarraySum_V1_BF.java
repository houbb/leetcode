package com.github.houbb.leetcode.f500t600;

public class T523_checkSubarraySum_V1_BF {


    /**
     * 思路：
     * 1. 构建前缀和数组
     * 2. 穷举，找到符合结果的数据。
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        final int n = nums.length;

        // 前缀和
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        // 穷举
        for(int step = 2; step < n-2; step++) {
            for(int i = 0; i < n-2; i++) {
                int sum = prefix[i+step] - prefix[i] + nums[i];
                if(sum % k == 0) {
                    return true;
                }
            }
        }


        return false;
    }

}
