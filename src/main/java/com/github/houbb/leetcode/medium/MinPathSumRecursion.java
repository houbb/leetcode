package com.github.houbb.leetcode.medium;

/**
 * 最小路径
 * @author binbin.hou
 * @since 1.0.0
 */
public class MinPathSumRecursion {

    /**
     * 解题思路：
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return getMin(grid, m-1, n-1);
    }
    private int getMin(int[][] grid, int i, int j) {
        // 起点位置
        if(i == 0 && j == 0) {
            return grid[0][0];
        }

        // 第一行，想到达这里，说明前面肯定是水平向右，否则肯定不会在第一行
        if(i == 0) {
            return grid[i][j] + getMin(grid, i, j-1);
        }
        // 第一列，说明肯定是垂直到打这里。否则肯定不会在第一列
        if(j == 0) {
            return grid[i][j] + getMin(grid, i-1, j);
        }

        // 直接返回当前 + 前面的最小值即可。
        int minRow = getMin(grid, i-1, j);
        int minColumn = getMin(grid, i, j-1);
        // 找到最小的距离
        return grid[i][j] + Math.min(minRow, minColumn);
    }

}
