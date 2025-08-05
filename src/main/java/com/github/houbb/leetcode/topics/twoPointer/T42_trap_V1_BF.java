package com.github.houbb.leetcode.topics.twoPointer;

public class T42_trap_V1_BF {

    public int trap(int[] height) {
        int sum = 0;
        for(int i = 1; i < height.length-1; i++) {
            // 左边最高
            int maxLeft = findMaxHeight(height, 0, i-1);
            // 右边最高
            int maxRight = findMaxHeight(height, i+1, height.length-1);
            // 当前
            int maxHeight = Math.min(maxLeft, maxRight);
            // 大于0才累加
            int curTrap = maxHeight - height[i];
            if(curTrap > 0) {
                sum  += curTrap;
            }
        }
        return sum;
    }

    private int findMaxHeight(int[] height, int startIx, int endIx) {
        int max = Integer.MIN_VALUE;

        for(int i = startIx; i <= endIx; i++) {
            if(height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }

}
