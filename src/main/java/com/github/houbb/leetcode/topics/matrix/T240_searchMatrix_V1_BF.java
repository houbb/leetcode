package com.github.houbb.leetcode.topics.matrix;

public class T240_searchMatrix_V1_BF {


    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

}
