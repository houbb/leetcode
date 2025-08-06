package com.github.houbb.leetcode.topics.matrix;

public class T73_matrixSetZero_V1_BF {

    public void setZeroes(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];

        // 处理
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                int num = matrix[i][j];
                if(num == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        // 再次遍历处理
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(rows[i] == 1
                    || cols[j] == 1) {
                    matrix[i][j] =  0;
                }
            }
        }
    }

}
