package com.github.houbb.leetcode.topics.greedy;

import java.util.ArrayList;
import java.util.List;

public class T56_mergeIntervals_V2_Recursive {


    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(interval);
        }

        List<int[]> merged = mergeRecursive(list);
        return merged.toArray(new int[merged.size()][]);
    }

    private List<int[]> mergeRecursive(List<int[]> intervals) {
        if (intervals.isEmpty()) return new ArrayList<>();

        int[] curr = intervals.remove(0);
        List<int[]> rest = new ArrayList<>();
        boolean merged = false;

        for (int[] other : intervals) {
            if (overlap(curr, other)) {
                curr = mergeTwo(curr, other);
                merged = true;
            } else {
                rest.add(other);
            }
        }

        if (merged) {
            // 可能还会跟 rest 中的其他区间重叠，继续递归
            rest.add(0, curr);
            return mergeRecursive(rest);
        } else {
            // 没有任何重叠，curr 已经是独立区间
            List<int[]> result = mergeRecursive(rest);
            result.add(0, curr); // 保证顺序
            return result;
        }
    }

    private boolean overlap(int[] a, int[] b) {
        return !(a[1] < b[0] || b[1] < a[0]);
    }

    private int[] mergeTwo(int[] a, int[] b) {
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }

}
