package com.github.houbb.leetcode.F100T200;

public class T174_DungeonGameV2 {

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
        Integer[][] mem = new Integer[dungeon.length+1][dungeon[0].length+1];
        //从左上角开始遍历
        return getCost(dungeon, 0, 0, mem);
    }

    // 0 我们的勇者就挂了，最少需要1滴血。
    private int getCost(int[][] dungeon, int i, int j, Integer[][] mem) {
        // 直接获取缓存
        if(mem[i][j] != null) {
            return mem[i][j];
        }

        // 结果，便于处理 cache
        int result = 1;

        int n = dungeon.length;
        int m = dungeon[0].length;
        if(i == n || j == m) {
            // 不可达
            result = Integer.MAX_VALUE;
        } else if (i == n-1 && j == m-1) {
            // 达到目标，返回结果
            if(dungeon[i][j] <= 0) {
                result = -dungeon[i][j] + 1;
            }
        } else {
            // 选择方式: 向右或者向下
            int goRightCost = getCost(dungeon, i+1, j, mem);
            int goBottomCost = getCost(dungeon, i, j+1, mem);

            // 路要怎么走？选择消耗最少的路
            // 这里直接减去当前值即可。正值加血，负值减血。直接减，得到消耗的血量。
            int minRequire = Math.min(goRightCost, goBottomCost) - dungeon[i][j];

            // 至少为1
            result  = Math.max(1, minRequire);
        }

        //cache
        mem[i][j] = result;

        return result;
    }

}
