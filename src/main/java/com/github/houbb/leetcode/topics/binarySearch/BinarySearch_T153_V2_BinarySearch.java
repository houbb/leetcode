package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T153_V2_BinarySearch {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        // 记录最小值
        int min = nums[0];

        while (left <= right) {
            int mid = left + (right-left) / 2;

            // 整体有序
            if(nums[left] <= nums[right]) {
                min = Math.min(min, nums[left]);
                return min;
            }

            // 更新最小值
            min = Math.min(min, nums[mid]);

            // 左边有序，最小值在右边
            if(nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                // 右边有序，最小值在左边
                right= mid-1;
            }
        }

        return min;
    }



}
