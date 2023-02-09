package com.github.houbb.leetcode.F000T100;

/**
 * 方格之间保留水的面积最大。
 *
 * 1. 水墙壁的宽度忽略，相邻2个间距为下标的差。
 * 2. 不可以倾斜。
 * 3. n 至少为 2
 * 4.考虑水的流动性，高度只能等于最短的。
 *
 * 图中有一个不合理的地方（或者中间挡板是可以让水通过的），可以考虑把中间挡板直接移除。
 *
 * 简单思路：遍历穷举
 * 进阶思路：DP
 *
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-11 14:57:39
 */
public class T011_ContainerWithMostWaterV2 {

    /**
     * 优化思路
     *
     * 1. 避免重复计算
     * 2. j 永远大于 i，跳过计算
     * @param height 高度数组
     * @return 结果
     * @since v2
     */
    public int maxAreaV2(int[] height) {
        int maxResult = -1;
        for(int i = 0; i < height.length; i++) {
            for(int j = i+1; j < height.length; j++) {
                int hi = height[i];
                int hj = height[j];
                int min = Math.min(hi, hj);
                int x = j-i;
                int area = x * min;

                if(area > maxResult) {
                    maxResult = area;
                }
            }
        }

        return maxResult;
    }

}
