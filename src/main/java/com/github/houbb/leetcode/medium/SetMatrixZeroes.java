package com.github.houbb.leetcode.medium;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class SetMatrixZeroes {

    /**
     * 空间复杂度：m+n
     *
     * 降低内存的技巧：如果某一行/列存在0，就将开始设置为 0..这样可以节约空间。
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int[] zeroRows = new int[rowNum];
        int[] zeroCols = new int[colNum];

        for(int i = 0; i < rowNum; i++) {
            for(int j = 0; j < colNum; j++) {
                int value = matrix[i][j];

                if(value == 0) {
                    zeroRows[i] = 1;
                    zeroCols[j] = 1;
                }
            }
        }

        // 遍历设置
        for(int i = 0; i < rowNum; i++) {
            for(int j = 0; j < colNum; j++) {
                int zeroRow = zeroRows[i];
                int zeroColumn = zeroCols[j];

                if(zeroRow == 1 || zeroColumn == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
