package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T154_V2_BinarySearch {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = nums[0];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 整体有序
            if (nums[left] < nums[right]) {
                min = Math.min(min, nums[left]);
                return min;
            }

            // 更新最小值
            min = Math.min(min, nums[mid]);

            if (nums[mid] > nums[right]) {
                // 最小值一定在右边
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // 最小值在 mid 或左边（不能跳过 mid）
                right = mid;
            } else {
                // nums[mid] == nums[right]，无法判断，保守缩小边界
                right--;
            }
        }

        return min;
    }



}
