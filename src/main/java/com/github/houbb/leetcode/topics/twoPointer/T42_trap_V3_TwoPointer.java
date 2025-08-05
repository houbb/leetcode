package com.github.houbb.leetcode.topics.twoPointer;

public class T42_trap_V3_TwoPointer {

    public int trap(int[] height) {
        // 初始化
        int n = height.length;
        int left = 0;
        int right = n-1;
        int leftMax = 0;
        int rightMax = 0;

        int sum = 0;


        // 经典循环
        while (left < right) {
            // 两边最大值
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            // 比较左右的那边高
            // 左边高，只看右边最大值即可
            if(height[left] > height[right]) {
                sum += rightMax - height[right];
                right--;
            } else {
                // 右边高 取决于左边
                sum += leftMax - height[left];
                left++;
            }
        }

        return sum;
    }

}
