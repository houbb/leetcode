package com.github.houbb.leetcode.topics.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T56_mergeIntervals_V4_sortAndTwoPointer {


    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        List<int[]> res = new ArrayList<>();
        for (int i = 0, j = 0; i < n; i++) {
            if (i == n - 1 || start[i + 1] > end[i]) { // 区间结束
                res.add(new int[]{start[j], end[i]});
                j = i + 1;
            }
        }
        return res.toArray(new int[res.size()][]);
    }


}
