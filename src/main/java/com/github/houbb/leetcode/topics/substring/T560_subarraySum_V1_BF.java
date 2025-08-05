package com.github.houbb.leetcode.topics.substring;

public class T560_subarraySum_V1_BF {

    public int subarraySum(int[] nums, int k) {
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                int sum = sum(i, j, nums);
                if(sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    private int sum(int startIx, int endIx, int[] nums) {
        int sum = 0;
        for(int i = startIx; i <= endIx; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
