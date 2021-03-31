package com.github.houbb.leetcode.F1300T1400;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class SortTheMatrixDiagonallyBest {


    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int offset = 1 - n;
        while (offset <= m - 1) {
            int i = Math.max(-offset, 0);
            int j = i + offset;
            sort(mat, i, j);
            offset++;
        }
        return mat;
    }

    private void sort(int[][] mat, int si, int sj) {
        int[] count = new int[101];
        int i = si;
        int j = sj;
        while (i < mat.length && j < mat[0].length) {
            count[mat[i][j]]++;
            i++;
            j++;
        }
        i = si;
        j = sj;
        int curr = 1;
        while (i < mat.length && j < mat[0].length) {
            while (count[curr] == 0) {
                curr++;
            }
            mat[i][j] = curr;
            count[curr]--;
            i++;
            j++;
        }
    }

}
