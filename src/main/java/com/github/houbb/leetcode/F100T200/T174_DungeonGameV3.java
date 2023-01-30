package com.github.houbb.leetcode.F100T200;

public class T174_DungeonGameV3 {

    /**
     * 计算最小需要的 hp
     *
     * 思路：dp，从右下角开始，到左上角结束。
     *
     * 递推公式是什么？
     *
     * 两条路，原来可以向 右/下。
     *
     * 反过来，就是向左，或者向上。
     *
     * https://leetcode.com/problems/dungeon-game/solutions/745340/post-dedicated-to-beginners-of-dp-or-have-no-clue-how-to-start/
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // 初始化 dp 数组
        int[][] dp = new int[m+1][n+1];
        // 默认填充为最大值
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[m][n-1] = 1;
        dp[m-1][n] = 1;

        // 遍历，从右下角开始往左上角。
        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                // 右下 最小的值
                int cost = Math.min(dp[i][j+1], dp[i+1][j]) - dungeon[i][j];
                // 最小需要1滴血
                dp[i][j] = Math.max(1, cost);
            }
        }

        return dp[0][0];
    }


}
