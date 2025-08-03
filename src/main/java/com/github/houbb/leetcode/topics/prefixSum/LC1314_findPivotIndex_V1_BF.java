package com.github.houbb.leetcode.topics.prefixSum;

public class LC1314_findPivotIndex_V1_BF {


    // 不包含自己
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] result = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                // 计算当前位置的和
                int calc = calc(mat, k, i, j);
                result[i][j] = calc;
            }
        }

        return result;
    }

    private int calc(int[][] mat,
                     int k,
                     int i, int j) {
        // 要包含结尾
        int sum = 0;
        int rowStart = Math.max(0, i-k);
        int rowEnd = Math.min(i+k, mat.length-1);
        int colStart = Math.max(0, j-k);
        int colEnd = Math.min(j+k, mat[0].length-1);
        for(int row=rowStart; row <= rowEnd; row++) {
            for(int col=colStart; col <= colEnd; col++) {
                sum += mat[row][col];
            }
        }

        return sum;
    }

}
