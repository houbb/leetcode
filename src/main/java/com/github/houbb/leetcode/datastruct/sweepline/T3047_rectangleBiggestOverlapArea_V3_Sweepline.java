package com.github.houbb.leetcode.datastruct.sweepline;

import java.util.*;

@Deprecated
public class T3047_rectangleBiggestOverlapArea_V3_Sweepline {

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        List<int[]> events = new ArrayList<>();
        for (int i = 0; i < bottomLeft.length; i++) {
            events.add(new int[]{bottomLeft[i][0], bottomLeft[i][1], topRight[i][1], 1}); // 左下角
            events.add(new int[]{topRight[i][0], bottomLeft[i][1], topRight[i][1], -1}); // 右上角
        }
        events.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[2] != b[2]) return a[2] - b[2];
            return a[1] - b[1];
        });

        TreeMap<Integer, Integer> yToCount = new TreeMap<>();
        int maxY = 0;
        long maxArea = 0;
        int prevX = 0;
        for (int[] event : events) {
            int x = event[0], y1 = event[1], y2 = event[2], type = event[3];
            if (type == 1) {
                yToCount.put(y1, yToCount.getOrDefault(y1, 0) + 1);
                yToCount.put(y2, yToCount.getOrDefault(y2, 0) + 1);
            } else {
                yToCount.put(y1, yToCount.get(y1) - 1);
                yToCount.put(y2, yToCount.get(y2) - 1);
                if (yToCount.get(y1) == 0) yToCount.remove(y1);
                if (yToCount.get(y2) == 0) yToCount.remove(y2);
            }

            // Calculate the maximum side length of the square that can be placed at position x
            int width = x - prevX;
            int height = Math.min(width, calculateMinHeight(yToCount, y1, y2));
            maxArea = Math.max(maxArea, (long) height * height);

            prevX = x;
        }
        return maxArea;
    }

    private int calculateMinHeight(TreeMap<Integer, Integer> yToCount, int y1, int y2) {
        int minHeight = Integer.MAX_VALUE;
        for (int y = y1; y <= y2; y++) {
            if (yToCount.containsKey(y)) {
                minHeight = Math.min(minHeight, yToCount.get(y));
            }
        }
        return minHeight;
    }

    public static void main(String[] args) {
        T3047_rectangleBiggestOverlapArea_V3_Sweepline solution = new T3047_rectangleBiggestOverlapArea_V3_Sweepline();

        // 示例 1
        int[][] bottomLeft1 = {{1, 1}, {2, 2}, {3, 1}};
        int[][] topRight1 = {{3, 3}, {4, 4}, {6, 6}};
        System.out.println(solution.largestSquareArea(bottomLeft1, topRight1));  // Output: 1

        // 示例 2
        int[][] bottomLeft2 = {{1, 1}, {2, 2}, {1, 2}};
        int[][] topRight2 = {{3, 3}, {4, 4}, {3, 4}};
        System.out.println(solution.largestSquareArea(bottomLeft2, topRight2));  // Output: 1

        // 示例 3
        int[][] bottomLeft3 = {{1, 1}, {3, 3}, {3, 1}};
        int[][] topRight3 = {{2, 2}, {4, 4}, {4, 2}};
        System.out.println(solution.largestSquareArea(bottomLeft3, topRight3));  // Output: 0
    }

}
