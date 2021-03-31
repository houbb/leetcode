package com.github.houbb.leetcode.F1300T1400;

import java.util.*;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class SortTheMatrixDiagonallyBetter {

    /**
     * 優化思路：
     *
     * （1）
     *
     * Runtime: 10 ms, faster than 23.65% of Java online submissions for Sort the Matrix Diagonally.
     * Memory Usage: 40 MB, less than 50.75% of Java online submissions for Sort the Matrix Diagonally.
     *
     * @param mat
     * @return
     */
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, PriorityQueue<Integer>> matMap = new HashMap<>();

        // 遍历每一个对角线
        int m = mat.length;
        int n = mat[0].length;

        // m*n
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                int index = i-j;

                PriorityQueue<Integer> queue = matMap.getOrDefault(index, new PriorityQueue<>());
                queue.add(mat[i][j]);
                matMap.put(index, queue);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                mat[i][j] = matMap.get(i-j).remove();
            }
        }

        return mat;
    }

}
