package com.github.houbb.leetcode.datastruct.sweepline;

public class T836_rectangleOverlap_V2_overlapArea {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
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
            return true;
        }

        // 没有重叠
        return false;
    }

}
