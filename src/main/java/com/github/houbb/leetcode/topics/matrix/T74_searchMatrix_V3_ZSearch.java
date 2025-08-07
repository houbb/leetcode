package com.github.houbb.leetcode.topics.matrix;

public class T74_searchMatrix_V3_ZSearch {


    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 从右上角开始
        int row = 0;
        int col = n - 1;
        // 往左走，变小   往下走，变大
        // 要求：左边 >= 0   下边 < m

        while (row < m && col >= 0) {
            int cur = matrix[row][col];
            if(cur == target) {
                return true;
            }
            if(cur > target) {
                col--;
            }
            if(cur < target) {
                row++;
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
