package com.github.houbb.leetcode.topics.twoPointer;

public class T11_maxArea_V3_TwoPointerOpt {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,2,4,3}));
    }
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;

        while (left < right) {
            int h = Math.min(height[left], height[right]);

            int area = (right-left) * h;
            maxArea = Math.max(area, maxArea);

            int curLeft = height[left];
            int curRight = height[right];

            // 比较两边的高度
            if(curLeft >= curRight) {
                while (left < right && height[right] <= curRight) {
                    right--;
                }
            } else {
                while (left < right && height[left] <= curLeft) {
                   left++;
                }
            }
        }

        return maxArea;
    }

}
