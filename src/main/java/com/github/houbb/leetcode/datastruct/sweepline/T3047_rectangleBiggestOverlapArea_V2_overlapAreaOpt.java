package com.github.houbb.leetcode.datastruct.sweepline;

public class T3047_rectangleBiggestOverlapArea_V2_overlapAreaOpt {


    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long maxValue = 0;
        final int len = bottomLeft.length;
        for(int i = 0; i < len-1; i++) {
            for(int j = i+1; j < len; j++) {
                long overlap = rectangleOverlapArea(bottomLeft[i], topRight[i], bottomLeft[j], topRight[j]);
                maxValue = Math.max(maxValue, overlap);
            }
        }
        return maxValue;
    }

    public long rectangleOverlapArea(int[] bottomLeft1, int[] topRight1, int[] bottomLeft2, int[] topRight2) {
        // 计算交集矩形的左下角和右上角
        int x1 = Math.max(bottomLeft1[0], bottomLeft2[0]);
        int y1 = Math.max(bottomLeft1[1], bottomLeft2[1]);

        int x2 = Math.min(topRight1[2], topRight2[2]);
        int y2 = Math.min(topRight1[3], topRight2[3]);

        // 计算交集的宽度和高度
        int width = x2 - x1;
        int height = y2 - y1;

        // 如果交集的宽度和高度都大于 0，说明有重叠
        // 这里取正方形，二者最小的长度
        if (width > 0 && height > 0) {
            long len = Math.min(width, height);
            return len * len;
        }

        // 没有重叠
        return 0L;
    }

}
