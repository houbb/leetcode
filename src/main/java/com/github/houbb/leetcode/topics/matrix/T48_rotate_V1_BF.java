package com.github.houbb.leetcode.topics.matrix;

import java.util.ArrayList;
import java.util.List;

public class T48_rotate_V1_BF {


    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 只是为了避免覆盖而已
        int[][] copy = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                copy[i][j] = matrix[i][j];
            }
        }

        // 开始从 copy 直接覆盖到 matrix
        // 从左到右
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // 新的行 == 原始的列
                // 新的列 == (n-原始行)
                matrix[j][n-i-1] = copy[i][j];
            }
        }
    }



}
