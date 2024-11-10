package com.github.houbb.leetcode.datastruct.array;

public class T167_twoSum_V1_BF {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        final int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(nums[i] + nums[j] == target) {
                    res[0] = i+1;
                    res[1] = j+1;
                }
            }
        }

        return res;
    }

}
