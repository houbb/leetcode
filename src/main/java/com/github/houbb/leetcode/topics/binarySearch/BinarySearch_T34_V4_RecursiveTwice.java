package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T34_V4_RecursiveTwice {

    public int[] searchRange(int[] nums, int target) {
        // 左右遍历，找到结果
        int left = binarySearchFirst(nums, target, 0, nums.length-1);
        int right = binarySearchLast(nums, target, 0, nums.length-1);

        return new int[]{left, right};
    }


    public int binarySearchFirst(int[] nums, int target, int left, int right) {
        // NOT FOUND
        if(left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        int midVal = nums[mid];

        // 小于，则在右边
        if(midVal < target) {
            return binarySearchFirst(nums, target, mid+1, right);
        }
        // 大于，则在左边
        if(midVal > target) {
            return binarySearchFirst(nums, target, left, mid-1);
        }

        // 等于的时候，需要进一步处理向左边寻找
        int temp = binarySearchFirst(nums, target, left, mid-1);
        // 存在重复值，则为左边的
        if(temp != -1) {
            return temp;
        }
        // 不存在重复，就是 mid 值
        return mid;
    }

    public int binarySearchLast(int[] nums, int target, int left, int right) {
        // NOT FOUND
        if(left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        int midVal = nums[mid];

        // 小于，则在右边
        if(midVal < target) {
            return binarySearchLast(nums, target, mid+1, right);
        }
        // 大于，则在左边
        if(midVal > target) {
            return binarySearchLast(nums, target, left, mid-1);
        }

        // 等于的时候，需要进一步处理向右边寻找
        int temp = binarySearchLast(nums, target, mid+1, right);
        // 存在重复值，则为左边的
        if(temp != -1) {
            return temp;
        }
        // 不存在重复，就是 mid 值
        return mid;
    }


}
