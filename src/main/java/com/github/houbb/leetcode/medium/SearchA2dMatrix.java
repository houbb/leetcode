package com.github.houbb.leetcode.medium;

import java.util.Arrays;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class SearchA2dMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rangeIndex = getRangeIndex(matrix, target);

        if(rangeIndex < 0) {
            return false;
        }

        int[] array = matrix[rangeIndex];

        return Arrays.binarySearch(array, target) >= 0;
    }


    // 获取范围所在的下标
    private int getRangeIndex(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length-1;

        while (low <= high) {
            int mid = (high+low) / 2;

            int[] array = matrix[mid];
            // 刚好在范围内
            if(target >= array[0] && target <= array[array.length-1]) {
                return mid;
            } else if(target < array[0]) {
                // 目标数值较小
                high = mid - 1;
            } else {
                low = mid+1;
            }
        }

        return -1;
    }


    // 1 2 3 4 5
    public static void main(String[] args) {
        SearchA2dMatrix searchA2dMatrix = new SearchA2dMatrix();
        int[][] matrix = new int[][]{
                {1},
                {3}
        };
        searchA2dMatrix.searchMatrix(matrix, 2);
    }

}
