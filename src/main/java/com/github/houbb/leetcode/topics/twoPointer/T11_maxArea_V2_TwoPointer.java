package com.github.houbb.leetcode.topics.twoPointer;

public class T11_maxArea_V2_TwoPointer {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,2,4,3}));
    }
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;

        while (left < right) {
            // 面积
            int w = right - left;
            int h = Math.min(height[left], height[right]);

            int area = w * h;
            maxArea = Math.max(area, maxArea);

            // 比较两边的高度
            if(height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }

}
