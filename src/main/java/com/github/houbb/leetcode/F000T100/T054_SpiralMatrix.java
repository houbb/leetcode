package com.github.houbb.leetcode.F000T100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T054_SpiralMatrix {


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
     * @param matrix 矩阵
     * @return 结果
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 避免扩容
        int total = m * n;
        List<Integer> results = new ArrayList<>(total);

        int mStart = 0;
        int mEnd = m-1;
        int nStart = 0;
        int nEnd = n-1;

        while (results.size() < total) {
            // 从左到右
            for(int i = nStart; i <= nEnd; i++) {
                results.add(matrix[mStart][i]);
            }
            if(results.size() >= total) {
                return results;
            }
            mStart++;

            // 从上到下
            for(int i = mStart; i <= mEnd; i++) {
                results.add(matrix[i][nEnd]);
            }
            if(results.size() >= total) {
                return results;
            }
            nEnd--;

            // 从右向左
            for(int i = nEnd; i >= nStart; i--) {
                results.add(matrix[mEnd][i]);
            }
            if(results.size() >= total) {
                return results;
            }
            mEnd--;

            //从下到上
            for(int i = mEnd; i >= mStart; i--) {
                results.add(matrix[i][nStart]);
            }
            if(results.size() >= total) {
                return results;
            }
            nEnd++;

            // 如果遍历一圈的话
            nStart++;
            nEnd--;
        }


        return results;
    }

    public static void main(String[] args) {
        T054_SpiralMatrix matrix = new T054_SpiralMatrix();
//        int[][] arrays = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9},
//        };

        int[][] arrays2 = {
                {1,2 ,3 ,4 },
                {5,6 ,7 ,8 },
                {9,10,11,12}
        };

//        System.out.println(matrix.spiralOrder(arrays));
        System.out.println(matrix.spiralOrder(arrays2));
    }

}
