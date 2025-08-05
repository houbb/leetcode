package com.github.houbb.leetcode.topics.twoPointer;

public class T42_trap_V2_Dp {

    public int trap(int[] height) {
        int sum = 0;

        // 初始化右边的最大值数组 逆序
        int n = height.length;
        int[] maxHeightRights = new int[n];
        maxHeightRights[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 1; i--) {
            // 当前位置和右边的最大值对比
            // 甚至看到了 dp 的影子
            maxHeightRights[i] = Math.max(height[i], maxHeightRights[i + 1]);
        }

        // 左边最大值
        int maxLeft = height[0];
        for (int i = 1; i < n - 1; i++) {
            // 右边最高
            int maxRight = maxHeightRights[i];
            // 当前
            int maxHeight = Math.min(maxLeft, maxRight);
            // 大于0才累加
            int curTrap = maxHeight - height[i];
            if (curTrap > 0) {
                sum += curTrap;
            }

            // 更新左边的最大值
            if (height[i] > maxLeft) {
                maxLeft = height[i];
            }
        }
        return sum;
    }

}
