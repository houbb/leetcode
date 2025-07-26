package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T35_V2_Recursive {

    public int searchInsert(int[] nums, int target) {
        return searchInsertRecursive(nums, 0, nums.length-1, target);
    }

    public int searchInsertRecursive(int[] nums, int left, int right, int target) {
        // 终止，返回 left
        if(left > right) {
            return left;
        }

        int mid = left + (right-left) / 2;

        // 匹配
        if(nums[mid] == target) {
            return mid;
        }
        // 小，去右侧找
        if(nums[mid] < target) {
            return searchInsertRecursive(nums, mid+1, right, target);
        }
        // 大，去左侧找
        return searchInsertRecursive(nums, left, mid-1, target);
    }

}
