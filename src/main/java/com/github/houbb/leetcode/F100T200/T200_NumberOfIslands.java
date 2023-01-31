package com.github.houbb.leetcode.F100T200;

public class T200_NumberOfIslands {

    /**
     * DFS
     *
     * 1. 遍历，找到第一个 1
     * 2. 上下左右遍历，把经过的位置置为 0
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int c = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    c++;
                }
            }
        }

        return c;
    }

    private void dfs(char[][] grid, int i, int j) {
        //1. 如果超过边界，或者不是 1，则返回
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
            || grid[i][j] != '1') {
            return;
        }

        // 当前位置为0
        grid[i][j] = '0';

        // 四个方向递归
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }

}
