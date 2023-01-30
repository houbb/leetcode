package com.github.houbb.leetcode.F100T200;

public class T174_DungeonGame {

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
     * 首先使用递归的方式。
     *
     * 41 / 45
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        //从左上角开始遍历
        return getCost(dungeon, 0, 0);
    }

    // 0 我们的勇者就挂了，最少需要1滴血。
    private int getCost(int[][] dungeon, int i, int j) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        // 如果是超过边界，则返回一个比较大的值
        if(i == n
            || j == m) {
            // 加法越界？
            return Integer.MAX_VALUE;
        }

        // 如果达到目标，则结束
        if(i == n-1
            && j == m-1) {
            // 消耗血
            if(dungeon[i][j] <= 0) {
                return -dungeon[i][j] + 1;
            }
            // 至少需要1滴血
            return 1;
        }

        // 选择方式: 向右或者向下
        int goRightCost = getCost(dungeon, i+1, j);
        int goBottomCost = getCost(dungeon, i, j+1);

        // 路要怎么走？选择消耗最少的路
        // 这里直接减去当前值即可。正值加血，负值减血。直接减，得到消耗的血量。
        int minRequire = Math.min(goRightCost, goBottomCost) - dungeon[i][j];

        // 至少为1
        return Math.max(1, minRequire);
    }

}
