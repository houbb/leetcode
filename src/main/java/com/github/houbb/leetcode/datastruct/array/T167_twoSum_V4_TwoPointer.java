package com.github.houbb.leetcode.datastruct.array;

public class T167_twoSum_V4_TwoPointer {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                return new int[]{left+1, right+1};
            }
            if(sum < target) {
                left++;
            }
            if(sum > target) {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
    
}
