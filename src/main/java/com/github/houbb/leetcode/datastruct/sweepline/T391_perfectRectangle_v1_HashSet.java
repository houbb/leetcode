package com.github.houbb.leetcode.datastruct.sweepline;

import java.util.*;

public class T391_perfectRectangle_v1_HashSet {

    /**
     * 思路：
     *
     * 1. 所有的重合点移除-通过 HashMap 实现
     * 2. 所有的面积之和等于最后的正方形面积。
     *
     * 给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。
     *
     * 那么对应的 4 个点为：
     * (xi, bi) (ai, bi)
     * (xi, yi) (ai, yi)
     *
     * @param rectangles
     * @return
     */
    public boolean isRectangleCover(int[][] rectangles) {
        // 定义事件列表
        int totalArea = 0;
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        // 顶点集合
        Set<String> points = new HashSet<>();

        for (int[] rect : rectangles) {
            int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];

            // 更新边界
            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);

            // 累加面积
            totalArea += (x2 - x1) * (y2 - y1);

            // 更新顶点集合
            String[] corners = {
                    x1 + "," + y1, x1 + "," + y2, x2 + "," + y1, x2 + "," + y2
            };
            for (String corner : corners) {
                if (!points.add(corner)) {
                    points.remove(corner);
                }
            }
        }

        // 顶点检查：精确覆盖的矩形应该只有 4 个顶点
        if (points.size() != 4 ||
                !points.contains(minX + "," + minY) ||
                !points.contains(minX + "," + maxY) ||
                !points.contains(maxX + "," + minY) ||
                !points.contains(maxX + "," + maxY)) {
            return false;
        }

        // 检查总面积是否一致
        int expectedArea = (maxX - minX) * (maxY - minY);
        return expectedArea == totalArea;
    }

}
