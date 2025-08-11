package com.github.houbb.leetcode.topics.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T56_mergeIntervals_V5_sweepLine {


    public int[][] merge(int[][] intervals) {
        List<int[]> events = new ArrayList<>();
        for (int[] in : intervals) {
            events.add(new int[]{in[0], 1}); // 起点
            events.add(new int[]{in[1], -1}); // 终点
        }
        events.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        List<int[]> res = new ArrayList<>();
        int count = 0, start = 0;
        for (int[] e : events) {
            if (count == 0) start = e[0];
            count += e[1];
            if (count == 0) res.add(new int[]{start, e[0]});
        }
        return res.toArray(new int[0][]);
    }


}
