package com.github.houbb.leetcode.topics.matrix;

public class T74_searchMatrix_V4_AllBinarySearch {



    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m*n-1;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            int midVal = matrix[mid / n][mid % n];

            if(midVal == target) {
                return true;
            } else if(midVal < target) {
                // 小 去右边
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return false;
    }

}
