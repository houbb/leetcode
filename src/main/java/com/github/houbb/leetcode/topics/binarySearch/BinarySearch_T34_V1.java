package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T34_V1 {

    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if(index == -1) {
            return new int[]{-1, -1};
        }

        // 左右遍历，找到结果
        int left = index;
        int right = index;

        while (left > 0) {
            if(nums[left-1] == target) {
                left--;
            } else {
                break;
            }
        }
        while (right < nums.length-1) {
            if(nums[right+1] == target) {
                right++;
            } else {
                break;
            }
        }

        return new int[]{left, right};
    }


    public int binarySearch(int[] nums, int target) {
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
        return -1;
    }

}
