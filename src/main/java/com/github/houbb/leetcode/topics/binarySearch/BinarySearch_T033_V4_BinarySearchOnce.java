package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T033_V4_BinarySearchOnce {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = left + (right-left) / 2;
            if(nums[mid] == target) {
                return mid;
            }

            // 判断左右两侧那边有顺序 值互不相同，需要判断等于吗？
            // 本次分割，左侧有序
            if(nums[left] <= nums[mid]) {
                // 判断当前的数是否在 [left, mid) 中，如果是，则说明 target 在这一半的左侧
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                // 右侧有顺序
                // 如果 target 位于 (mid, target] 中，则说明 target 在这一半的右侧
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }

        return -1;
    }




}
