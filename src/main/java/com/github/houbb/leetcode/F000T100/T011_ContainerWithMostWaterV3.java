package com.github.houbb.leetcode.F000T100;

import java.util.*;

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
public class T011_ContainerWithMostWaterV3 {

    /**
     * 双指针法
     *
     * 【思路】
     *
     * 首先从 l=0, r=height.length-1（两边）
     *
     * （1）比较二者数字大小
     *
     * if(height[l] < height[r]) {
     *      // 左边小，那么高度被固定，右边移动已经达到最大。只能左边向右移动
     * } else {
     *     // 右边下，右边高度被固定，只能最右往左移动。
     * }
     *
     * （2）终止条件
     * l >= R 则终止。
     *
     * （3）优化点
     *
     * 因为每次只移动一位，所以不需要每次都采用减法，直接使用变量保存即可。
     * 大小比较实用内部方法，而不是 Math 的方法。
     *
     * 【效果】
     *
     * Runtime: 2 ms, faster than 95.28% of Java online submissions for Container With Most Water.
     * Memory Usage: 40 MB, less than 38.16% of Java online submissions for Container With Most Water.
     * @param height 高度列表
     * @return 结果
     * @since best
     */
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int maxArea = 0;
        int width = height.length-1;

        while (l < r) {
            int area = min(height[l], height[r]) * (width);
            maxArea = max(area, maxArea);

            // 考虑如何移动指针
            if(height[l] >= height[r]) {
                // 左边比较大
                r--;
            } else {
                l++;
            }
            width--;
        }
        return maxArea;
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

}
