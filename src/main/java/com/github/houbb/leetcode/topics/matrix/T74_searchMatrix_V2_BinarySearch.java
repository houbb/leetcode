package com.github.houbb.leetcode.topics.matrix;

public class T74_searchMatrix_V2_BinarySearch {


    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            int[] nums = matrix[i];
            int index = binarySearch(nums, target);
            if(index > -1) {
                return true;
            }
        }

        return false;
    }


    // 返回对应的位置
    private int binarySearch(int[] nums, int target) {
        // 提前判断这一行是否可能存在
        if(target < nums[0] || target > nums[nums.length-1]) {
            return -1;
        }

        int left = 0;
        int right = nums.length-1;

        // 要等于吗？
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target ) {
                // 太大，那么就去左边
                right = mid-1;
            } else {
                // 太小，在右边
                left = mid+1;
            }
        }

        return -1;
    }

}
