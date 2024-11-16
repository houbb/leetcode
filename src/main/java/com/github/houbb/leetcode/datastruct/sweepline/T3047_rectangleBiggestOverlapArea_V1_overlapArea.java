package com.github.houbb.leetcode.datastruct.sweepline;

public class T3047_rectangleBiggestOverlapArea_V1_overlapArea {


    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long maxValue = 0;
        final int len = bottomLeft.length;
        for(int i = 0; i < len-1; i++) {
            for(int j = i+1; j < len; j++) {
                int[] rect1 = new int[]{bottomLeft[i][0],bottomLeft[i][1], topRight[i][0], topRight[i][1]};
                int[] rect2 = new int[]{bottomLeft[j][0],bottomLeft[j][1], topRight[j][0], topRight[j][1]};
                long overlap = rectangleOverlapArea(rect1, rect2);
                maxValue = Math.max(maxValue, overlap);
            }
        }
        return maxValue;
    }

    public long rectangleOverlapArea(int[] rec1, int[] rec2) {
        // 计算交集矩形的左下角和右上角
        int x1 = Math.max(rec1[0], rec2[0]);
        int y1 = Math.max(rec1[1], rec2[1]);
        int x2 = Math.min(rec1[2], rec2[2]);
        int y2 = Math.min(rec1[3], rec2[3]);

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
