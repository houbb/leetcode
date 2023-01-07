package com.github.houbb.leetcode.F000T100;

/**
 * @author d
 * @since 1.0.0
 */
public class T042_TrappingRainWater {

    /**
     * 计算
     *
     * 1. 两个数组保存两边的高度
     *
     * 2. 循环计算
     *
     * @param height 高度
     * @return 结果
     */
    public int trap(int[] height) {
        int n = height.length;

        //1. 最大高低数组
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        //1.1 左边 从左到右
        for(int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i-1], leftMax[i-1]);
        }
        //1.2 右边 从右到左
        for(int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i+1], rightMax[i+1]);
        }

        //2. 遍历计算
        int sum = 0;
        for(int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);

            sum += Math.max(0,  waterLevel - height[i]);
        }
        return sum;
    }


}
