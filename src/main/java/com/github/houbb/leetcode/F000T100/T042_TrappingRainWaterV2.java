package com.github.houbb.leetcode.F000T100;

/**
 * @author d
 * @since 1.0.0
 */
public class T042_TrappingRainWaterV2 {

    /**
     * 计算
     *
     * 1. 通过双指针，实时计算
     *
     * @param height 高度
     * @return 结果
     */
    public int trap(int[] height) {
        int n = height.length;

        //1. 最大高度
        int left = 0;
        int right = n-1;
        int maxLeft = height[left];
        int maxRight = height[right];

        int sum = 0;
        while (left <= right) {
            // 取决于左边
            if(maxLeft < maxRight) {
                if(height[left] > maxLeft) {
                    // 无法蓄水
                    maxLeft = height[left];
                } else {
                    // 可以蓄水
                    sum += maxLeft - height[left];
                }

                // 左边指针往右移动
                left++;
            } else {
                // 取决于右边
                if(height[right] > maxRight) {
                    // 无法蓄水
                    maxRight = height[right];
                } else {
                    // 可以蓄水
                    sum += maxRight - height[right];
                }

                // 右边指针往左移动
                right--;
            }
        }

        return sum;
    }


}
