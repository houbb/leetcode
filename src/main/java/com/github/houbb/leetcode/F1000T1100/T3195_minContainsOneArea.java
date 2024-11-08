package com.github.houbb.leetcode.F1000T1100;

public class T3195_minContainsOneArea {

    public static void main(String[] args) {
        T3195_minContainsOneArea solution = new T3195_minContainsOneArea();

        // 示例1
        int[][] grid1 = {
                {0, 1, 0},
                {1, 0, 1}
        };
        System.out.println(solution.minimumArea(grid1));  // 输出：6

        // 示例2
        int[][] grid2 = {
                {0, 0},
                {1, 0}
        };
        System.out.println(solution.minimumArea(grid2));  // 输出：1
    }

    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 最low的解法，遍历找到最小的 x,y 和最大的 x,y
        int xMin = m, yMin = n;
        int xMax = 0, yMax = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // 如果是1
                if (grid[i][j] == 1) {
                    xMin = Math.min(xMin, i);
                    yMin = Math.min(yMin, j);
                    xMax = Math.max(xMax, i);
                    yMax = Math.max(yMax, j);
                }
            }
        }
        // 面积需要+1
        return (xMax - xMin + 1) * (yMax - yMin + 1);
    }


}
