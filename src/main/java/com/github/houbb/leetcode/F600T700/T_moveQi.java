package com.github.houbb.leetcode.F600T700;

import java.util.HashSet;
import java.util.Set;

public class T_moveQi {

    public static void main(String[] args) {

    }

    private int n;

    public T_moveQi(final int n) {
        this.n = n;
    }

    // 内部变量
    private int[][] rows = new int[n][3];
    private int[][] cols = new int[n][3];
    private int[] nas = new int[3];
    private int[] pies = new int[3];
    public int move(int i, int j, int player) {
        // 首先更新
        rows[i][player] = rows[i][player]+1;
        cols[j][player] = cols[j][player]+1;
        if(i == j) {
            nas[player] = nas[player]+1;
        }
        if(i + j == n-1) {
            pies[player] = pies[player]+1;
        }
        // 然后判断
        if(rows[i][player] == n || cols[j][player] == n || nas[player] == n || pies[player] == n) {
            return player;
        }
        return 0;
    }

}
