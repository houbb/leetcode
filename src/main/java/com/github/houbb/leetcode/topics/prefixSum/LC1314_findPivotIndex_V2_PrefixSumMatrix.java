package com.github.houbb.leetcode.topics.prefixSum;

public class LC1314_findPivotIndex_V2_PrefixSumMatrix {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefixSum = new int[m+1][n+1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                prefixSum[i+1][j+1] = prefixSum[i][j+1] + prefixSum[i+1][j] - prefixSum[i][j] + mat[i][j];
            }
        }

        // 累加
        int[][] result = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                // 计算当前位置的和
                int calc = calc(mat, k, i, j, prefixSum);
                result[i][j] = calc;
            }
        }

        return result;
    }

    private int calc(int[][] mat,
                     int k,
                     int i, int j,
                     int[][] prefixSum) {
        // 要包含结尾
        int rowStart = Math.max(0, i-k);
        int rowEnd = Math.min(i+k, mat.length-1);
        int colStart = Math.max(0, j-k);
        int colEnd = Math.min(j+k, mat[0].length-1);

        return prefixSum[rowEnd+1][colEnd+1] - prefixSum[rowStart][colEnd+1] - prefixSum[rowEnd+1][colStart] + prefixSum[rowStart][colStart];
    }

}
