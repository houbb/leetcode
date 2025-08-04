package com.github.houbb.leetcode.topics.twoPointer;

public class T11_maxArea_V1_BF {

    public int maxArea(int[] height) {
        int maxArea = 0;

        for(int i = 0; i < height.length-1; i++) {
            for(int j = i+1; j < height.length; j++) {
                int w = j-i;
                int h = Math.min(height[i], height[j]);
                maxArea = Math.max(w*h, maxArea);
            }
        }

        return maxArea;
    }

}
