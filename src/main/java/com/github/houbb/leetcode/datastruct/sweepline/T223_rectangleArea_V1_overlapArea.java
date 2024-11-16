package com.github.houbb.leetcode.datastruct.sweepline;

public class T223_rectangleArea_V1_overlapArea {


    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int rect1 = rectangleArea(ax1, ay1, ax2, ay2);
        int rect2 = rectangleArea(bx1, by1, bx2, by2);

        int overlap = rectangleOverlapArea(new int[]{ax1, ay1, ax2, ay2}, new int[]{bx1, by1, bx2, by2});

        return rect1-overlap+rect2;
    }

    private int rectangleArea(int ax1, int ay1, int ax2, int ay2) {
        return (ax2-ax1) * (ay2-ay1);
    }

    public int rectangleOverlapArea(int[] rec1, int[] rec2) {
        // 计算交集矩形的左下角和右上角
        int x1 = Math.max(rec1[0], rec2[0]);
        int y1 = Math.max(rec1[1], rec2[1]);
        int x2 = Math.min(rec1[2], rec2[2]);
        int y2 = Math.min(rec1[3], rec2[3]);

        // 计算交集的宽度和高度
        int width = x2 - x1;
        int height = y2 - y1;

        // 如果交集的宽度和高度都大于 0，说明有重叠
        if (width > 0 && height > 0) {
            return width * height;
        }

        // 没有重叠
        return 0;
    }

}
