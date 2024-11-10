package com.github.houbb.leetcode.datastruct.array;

public class T167_twoSum_V2_SortBinarySearch {

    public int[] twoSum(int[] nums, int target) {
        final int n = nums.length;
        for(int i = 0; i < n; i++) {
            int other = target - nums[i];

            int j = binarySearch(nums, other, i+1);
            if(j >= 0) {
                return new int[]{i+1, j+1};
            }
        }

        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums,
                             int target,
                             int startIx) {
        int left = startIx;
        int right = nums.length-1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = nums[mid];
            if(val == target) {
                return mid;
            }
            if(val > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return -1;
    }
    
}
