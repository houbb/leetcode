package com.github.houbb.leetcode.medium;

import com.github.houbb.leetcode.util.MultiArrays;

import java.util.ArrayList;
import java.util.List;

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
public class SpiralMatrixIIBasic {


    /**
     * 实现思路：
     *
     * 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
     *
     * 说明：虽然已经是 100%，但是实际上并不是极限。
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
        SpiralMatrixIIBasic matrix = new SpiralMatrixIIBasic();

        MultiArrays.show(matrix.generateMatrix(3));
    }

}
