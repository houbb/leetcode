package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T34_V3_LoopTwice {

    public int[] searchRange(int[] nums, int target) {
        // 左右遍历，找到结果
        int left = binarySearchFirst(nums, target);
        int right = binarySearchLast(nums, target);

        return new int[]{left, right};
    }


    public int binarySearchFirst(int[] nums, int target) {
        int res = -1;
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 第一个，那么大于等于的 target 时候，继续往左边
            // 这里等于，并不是直接返回
            if(nums[mid] >= target) {
                right = mid-1;
            } else {
                left = mid+1;
            }

            // 临时记录一下 res，避免往左找不到了
            if(nums[mid] == target) {
                res = mid;
            }
        }

        return res;
    }

    public int binarySearchLast(int[] nums, int target) {
        int res = -1;
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 第一个，那么小于等于的 target 时候，继续往右边
            // 这里等于，并不是直接返回
            if(nums[mid] <= target) {
                left = mid+1;
            } else {
                right = mid-1;
            }

            // 临时记录一下 res，避免往左找不到了
            if(nums[mid] == target) {
                res = mid;
            }
        }

        return res;
    }


}
