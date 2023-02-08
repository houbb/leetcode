package com.github.houbb.leetcode.F000T100;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T063_UniquePathsII {

    /**
     * 解题思路：
     *
     * (1) 算出所有可能的路径
     * （2）移除中间有障碍的路径
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        // 初始化
        for(int i = 0; i < m; i++) {
            // 存在障碍物
            if(obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++) {
            // 存在障碍物
            if(obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }

        // 遍历
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }

}
