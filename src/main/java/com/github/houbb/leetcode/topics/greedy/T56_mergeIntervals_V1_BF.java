package com.github.houbb.leetcode.topics.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class T56_mergeIntervals_V1_BF {


    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int[] itv : intervals) {
            list.add(itv);
        }

        boolean changed = true;

        while (changed) {
            changed = false;
            List<int[]> next = new ArrayList<>();

            while (!list.isEmpty()) {
                int[] curr = list.remove(0);
                boolean merged = false;

                for (int i = 0; i < list.size(); i++) {
                    int[] other = list.get(i);
                    if (overlap(curr, other)) {
                        curr = mergeTwo(curr, other);
                        list.remove(i);
                        merged = true;
                        changed = true;
                        break; // 本轮合并后，再重新处理 curr
                    }
                }

                if (merged) {
                    list.add(0, curr); // 把合并后的放回去继续处理
                } else {
                    next.add(curr); // 没有合并，收集结果
                }
            }

            list = next;
        }

        return list.toArray(new int[list.size()][]);
    }

    private boolean overlap(int[] a, int[] b) {
        return !(a[1] < b[0] || b[1] < a[0]);
    }

    private int[] mergeTwo(int[] a, int[] b) {
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }

}
