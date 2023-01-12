package com.github.houbb.leetcode.F000T100;

public class T084_LargestRectangleInHistogram {

    public static void main(String[] args) {
        T084_LargestRectangleInHistogram largestRectangleInHistogram = new T084_LargestRectangleInHistogram();

        System.out.println(largestRectangleInHistogram.largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(largestRectangleInHistogram.largestRectangleArea(new int[]{2,4}));
    }

    /**
     * 最大的长方形面积
     *
     * 1. 首先直接暴力计算一遍
     *
     * 87 / 98 TEL
     * @param heights 高度数组
     * @return 结果
     */
    public int largestRectangleArea(int[] heights) {
        // 最大值
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < heights.length; i++) {
            for(int j = i; j < heights.length; j++) {
                // 对比
                int width = j - i + 1;

                // 应该是从 i..j的最小值
                int minHeight = min(heights, i, j);

                max = Math.max(width * minHeight, max);
            }
        }

        return max;
    }

    private int min(int[] nums,
                    int i,
                    int j) {
        int min = Integer.MAX_VALUE;

        for(int k = i; k <= j; k++) {
            min = Math.min(min, nums[k]);
        }
        return min;
    }


}
