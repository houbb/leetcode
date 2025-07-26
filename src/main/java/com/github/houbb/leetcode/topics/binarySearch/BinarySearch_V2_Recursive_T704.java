package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_V2_Recursive_T704 {

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        if(left > right) {
            return -1;
        }

        int mid = left + (right-left) / 2;
        if(nums[mid] == target) {
            return mid;
        }

        // 去右侧
        if(nums[mid] < target) {
            return binarySearch(nums, mid+1, right, target);
        }
        // 左侧
        return binarySearch(nums, left, mid-1, target);
    }

}
