package com.github.houbb.leetcode.topics.prefixSum;

public class LC1277_CountSquareSubmatricesWithAllOnes_V2_PrefixSumMatrix {


    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefixSum = new int[m+1][n+1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                prefixSum[i+1][j+1] = prefixSum[i+1][j] + prefixSum[i][j+1] - prefixSum[i][j] + matrix[i][j];
            }
        }


        int maxSize = Math.max(m, n);
        // 边长范围
        int total = 0;
        for(int size = 1; size <= maxSize; size++) {
            // 计算所有可能得数量
            int squareArea = size * size;
            // 所有的点
            for(int i = 0; i <= m-size; i++) {
                for(int j=0; j <= n-size; j++) {
                    int sum = calcSum(matrix, i, j, size, prefixSum);
                    if(squareArea == sum) {
                        total++;
                    }
                }
            }
        }

        return total;
    }

    private int calcSum(int[][] matrix,
                        int i,
                        int j,
                        int size,
                        int[][] prefixSum) {
        // 注意边界值
        if(size == 1) {
            return matrix[i][j];
        }

        // 遍历累加
        int rowStart = i;
        int colStart = j;
        int rowEnd = i+size-1;
        int colEnd = j+size-1;

        return prefixSum[rowEnd+1][colEnd+1] - prefixSum[rowStart][colEnd+1] - prefixSum[rowEnd+1][colStart] + prefixSum[rowStart][colStart];
    }



}
