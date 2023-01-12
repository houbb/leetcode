package com.github.houbb.leetcode.F000T100;

public class T084_LargestRectangleInHistogramV2 {

//    public static void main(String[] args) {
//        T084_LargestRectangleInHistogramV2 largestRectangleInHistogram = new T084_LargestRectangleInHistogramV2();
//
//        System.out.println(largestRectangleInHistogram.largestRectangleArea(new int[]{2,1,5,6,2,3}));
//        System.out.println(largestRectangleInHistogram.largestRectangleArea(new int[]{2,4}));
//    }

    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;

            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }


}
