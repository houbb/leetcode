package com.github.houbb.leetcode.F1300T1400;

import java.util.*;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class SortTheMatrixDiagonally {

    /**
     * 基本情況考慮：
     *
     * （1）null 直接返回
     *
     * （2）如果只有一行，或者一列，直接返回。
     *
     * （3）理解什麽是對角綫？
     *
     *  (i, j)
     *
     *  i-j 的值是相同的在同一個對角綫中。
     *
     *  00 01 02
     *  10 11 12
     *  20 21 22
     *
     *  1 2 3 4
     *  1 2 3 4
     *  1 2 3 4
     *  1 2 3 4
     *
     *  3.1 如何遍历对角线？
     *
     *  3.2 排序之后，如何把对角线放到原来的位置？
     *
     *
     * Runtime: 11 ms, faster than 18.39% of Java online submissions for Sort the Matrix Diagonally.
     * Memory Usage: 39.7 MB, less than 72.55% of Java online submissions for Sort the Matrix Diagonally.
     *
     * @param mat
     * @return
     */
    public int[][] diagonalSort(int[][] mat) {
        // 防御编程
        if(mat == null) {
            return null;
        }
        // 快速返回
        if(mat.length == 1 || mat[0].length == 1) {
            return mat;
        }

        // 存储每一个对角线的内容
        Map<Integer, List<Integer>> matMap = new HashMap<>();

        // 遍历每一个对角线
        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                // 核心：i-j 相同，则在同一个对角线。
                int index = i-j;

                List<Integer> list = matMap.getOrDefault(index, new ArrayList<>());
                list.add(mat[i][j]);
                matMap.put(index, list);
            }
        }

        // 遍历 map，并且进行排序
        for(Map.Entry<Integer, List<Integer>> entry : matMap.entrySet()) {
            Collections.sort(entry.getValue());
        }

        // 如何放回去？
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                // 核心：i-j 相同，则在同一个对角线。
                int index = i-j;

                List<Integer> list = matMap.get(index);

                // 移除第一个元素
                mat[i][j] = list.remove(0);
            }
        }

        // 可以修改以前的数组，也可以新建一个数组，整体影响不大。
        return mat;
    }

}
