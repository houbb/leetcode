package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T35_V1 {

    public int searchInsert(int[] nums, int target) {
        // 二分查找
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            // 中点
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];
            if(target == midVal) {
                return mid;
            }

            // 小于，那么目标值应该在右边
            if(midVal < target) {
                left = mid+1;
            }
            // 大于，则目标值应该在左边
            if(midVal > target) {
                right = mid-1;
            }
        }

        // not found
        return left;
    }

}
