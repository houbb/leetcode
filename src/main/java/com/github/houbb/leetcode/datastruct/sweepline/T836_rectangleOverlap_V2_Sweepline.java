package com.github.houbb.leetcode.datastruct.sweepline;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class T836_rectangleOverlap_V2_Sweepline {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // 如果 rec1 和 rec2 的 x 范围没有交集，直接返回 false
        if (rec1[2] <= rec2[0] || rec1[0] >= rec2[2] || rec1[3] <= rec2[1] || rec1[1] >= rec2[3]) {
            return false;
        }

        // 创建事件列表
        List<int[]> events = new ArrayList<>();

        // rec1 生成的事件
        events.add(new int[]{rec1[0], rec1[1], rec1[3], 1}); // 左边界
        events.add(new int[]{rec1[2], rec1[1], rec1[3], -1}); // 右边界

        // rec2 生成的事件
        events.add(new int[]{rec2[0], rec2[1], rec2[3], 1}); // 左边界
        events.add(new int[]{rec2[2], rec2[1], rec2[3], -1}); // 右边界

        // 按 x 坐标排序，若 x 相同，右边界事件优先
        events.sort((a, b) -> a[0] == b[0] ? b[3] - a[3] : a[0] - b[0]);

        // 使用一个优先队列来维护活动的 y 区间
        TreeSet<int[]> activeIntervals = new TreeSet<>((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        for (int[] event : events) {
            int x = event[0], y1 = event[1], y2 = event[2], type = event[3];

            if (type == 1) { // 左边界
                // 插入 y 区间
                activeIntervals.add(new int[]{y1, y2});

                // 检查当前是否有重叠
                if (hasOverlap(activeIntervals)) {
                    return true;
                }
            } else { // 右边界
                // 移除 y 区间
                activeIntervals.remove(new int[]{y1, y2});
            }
        }

        return false;
    }

    // 检查是否有 y 区间重叠
    private boolean hasOverlap(TreeSet<int[]> activeIntervals) {
        int prevEnd = Integer.MIN_VALUE;
        for (int[] interval : activeIntervals) {
            if (interval[0] < prevEnd) {
                return true; // 有重叠
            }
            prevEnd = interval[1];
        }
        return false;
    }

}
