package com.github.houbb.leetcode.topics.prefixSum;

public class LC1277_CountSquareSubmatricesWithAllOnes_V3_PrefixSumMatrix_OPT {


    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefixSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixSum[i + 1][j + 1] = prefixSum[i + 1][j] + prefixSum[i][j + 1] - prefixSum[i][j] + matrix[i][j];
            }
        }


        // 边长范围
        int total = 0;
        // 计算所有可能得数量
        // 所有的点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 当前点最多能扩展到多大正方形
                int maxSize = Math.min(m - i, n - j);
                for (int size = 1; size <= maxSize; size++) {
                    int squareArea = size * size;

                    int rowEnd = i + size - 1;
                    int colEnd = j + size - 1;

                    int sum = prefixSum[rowEnd + 1][colEnd + 1]
                            - prefixSum[i][colEnd + 1]
                            - prefixSum[rowEnd + 1][j]
                            + prefixSum[i][j];

                    // 提前结束，说明后面都不满足
                    if (sum < squareArea) {
                        break;
                    }
                    total++;
                }
            }
        }

        return total;
    }

}
