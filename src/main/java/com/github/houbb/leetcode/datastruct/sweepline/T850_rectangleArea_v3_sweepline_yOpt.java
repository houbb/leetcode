package com.github.houbb.leetcode.datastruct.sweepline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Deprecated
public class T850_rectangleArea_v3_sweepline_yOpt {

    public int rectangleArea(int[][] rectangles) {
        int MOD = (int) 1e9 + 7;

        // Step 1: Create events
        List<int[]> events = new ArrayList<>();
        for (int[] rect : rectangles) {
            //x_left y1 y2 进入
            events.add(new int[]{rect[0], rect[1], rect[3], 1});  // Enter event
            //x_right y1 y2 离开
            events.add(new int[]{rect[2], rect[1], rect[3], -1}); // Exit event
        }

        // Step 2: Sort events by x-coordinate, with ties broken by type
        // 首先按照 x 排序; x 相同，优先处理进入事件（矩形的左边界）。这是因为进入事件需要先将当前矩形加入活动区间，之后处理退出事件时才能正确移除。
        events.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[3], b[3]));

        // Step 3: Process events
        // TreeMap 是为了保障数据有序，且平衡插入+remove 的复杂度为 logn
        TreeMap<Integer, Integer> active = new TreeMap<>(); // Active intervals
        int prevX = 0;
        long area = 0;

        for (int i = 0; i < events.size(); i++) {
            int[] event = events.get(i);
            int currX = event[0], y1 = event[1], y2 = event[2], type = event[3];

            // Calculate area since last x-coordinate
            // 从第二个元素开始计算
            // 面积 = (x 跨度) * 高度
            if (i > 0) {
                area += computeHeight(active) * (long) (currX - prevX);
                area %= MOD;
            }

            // Update active intervals
            if (type == 1) { // Enter event
                active.put(y1, active.getOrDefault(y1, 0) + 1);
                active.put(y2, active.getOrDefault(y2, 0) - 1);
            } else { // Exit event
                active.put(y1, active.getOrDefault(y1, 0) - 1);
                active.put(y2, active.getOrDefault(y2, 0) + 1);
            }

            // Remove intervals with count 0
            // 清空为0的数据，暂时不处理
            prevX = currX;
        }

        return (int) area;
    }

    // Helper function to compute the total height of active intervals
    private long computeHeight(TreeMap<Integer, Integer> active) {
        int minHeight = Integer.MAX_VALUE;
        int maxHeight = 0;
        for (Map.Entry<Integer, Integer> entry : active.entrySet()) {
            int y = entry.getKey(), count = entry.getValue();
            if (count > 0) {
                minHeight = Math.min(minHeight, y);
                maxHeight = Math.max(maxHeight, y);
            }
        }
        return (maxHeight - minHeight);
    }

}
