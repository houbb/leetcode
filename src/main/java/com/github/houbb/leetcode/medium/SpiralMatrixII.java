package com.github.houbb.leetcode.medium;

import com.github.houbb.leetcode.util.MultiArrays;

/**
 * 基本思路：
 *
 * （1）根据 n ，生成 n*n 的矩阵
 * （2）将数字按照顺序，设置到矩阵中。
 * （3）输出矩阵
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class SpiralMatrixII {


    /**
     * 实现思路：
     *
     * （1）第一行从左到右，最右列从上到下。
     * 最后一行，从右向左，最左列从下到上（）。
     *
     * 规则：
     * boolean[][] 是否 visited
     *
     * 从左到右，如果已经是最右边，或者是 visited，调整方向向下：
     *
     * 00 11 22 33
     * 00 11 22 33
     * 00 11 22 33
     * 00 11 22 33
     *
     * 备注：这种每次都判断大小的方式，一点都不优雅。
     *
     * @param n 矩阵大小
     * @return 结果
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        // 避免扩容
        int num = 1;
        int total = n * n;

        int mStart = 0;
        int mEnd = n-1;
        int nStart = 0;
        int nEnd = n-1;

        while (num <= total) {
            // 从左到右
            for(int i = nStart; i <= nEnd; i++) {
                // 设置
                matrix[mStart][i] = num++;
            }
            if(num > total) {
                return matrix;
            }
            mStart++;

            // 从上到下
            for(int i = mStart; i <= mEnd; i++) {
                matrix[i][nEnd] = num++;
            }
            if(num > total) {
                return matrix;
            }
            nEnd--;

            // 从右向左
            for(int i = nEnd; i >= nStart; i--) {
                matrix[mEnd][i] = num++;
            }
            if(num > total) {
                return matrix;
            }
            mEnd--;

            //从下到上
            for(int i = mEnd; i >= mStart; i--) {
                matrix[i][nStart] = num++;
            }
            if(num > total) {
                return matrix;
            }
            nEnd++;

            // 如果遍历一圈的话
            nStart++;
            nEnd--;
        }

        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixII matrix = new SpiralMatrixII();

        MultiArrays.show(matrix.generateMatrix(3));
    }

}
