package com.github.houbb.leetcode.topics.prefixSum;

public class LC1277_CountSquareSubmatricesWithAllOnes_V1_BF {


    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int maxSize = Math.max(m, n);

        // 边长范围
        int total = 0;
        for(int size = 1; size <= maxSize; size++) {
            // 计算所有可能得数量
            int squareArea = size * size;


            // 所有的点
            for(int i = 0; i <= m-size; i++) {
                for(int j=0; j <= n-size; j++) {
                    int sum = calcSum(matrix, i, j, size);
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
                        int size) {
        // 注意边界值
        if(size == 1) {
            return matrix[i][j];
        }

        // 遍历累加
        int sum = 0;
        for(int row = i; row < i+size; row++) {
            for(int col = j; col < j+size; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }



}
