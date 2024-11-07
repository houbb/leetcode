package com.github.houbb.leetcode.f500t600;

public class T525_findMaxLength_V1_prefixSum {

    public int findMaxLength(int[] nums) {
        final int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i+1] + nums[i];
        }

        // 从大大小遍历？
        for(int step = n; step >=1; step-=2) {
            for(int i = 0; i < n - step; i++) {
                int next = i + step;
                int sum = prefix[next] - prefix[i] + nums[i];
                if(sum == step / 2) {
                    return step;
                }
            }
        }
        return 0;
    }

}
