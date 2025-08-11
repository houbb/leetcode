package com.github.houbb.leetcode.topics.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class T56_mergeIntervals_V3_sortAndGreedy {


    public int[][] merge(int[][] intervals) {
        // 按照开始位置排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int n = intervals.length;

        //greedy 其实是最难得 因为每次贪心的策略都不同
        List<int[]> tempList = new ArrayList<>();

        // 遍历所有区间，如果当前的起点在上一个末尾之前，则合并
        // 如果在上一个区间末尾之后，则把上一个区间放到答案中去
        int[] pre = intervals[0];
        for(int i = 1; i < n; i++) {
            int[] cur = intervals[i];
            // 如果当前的起点在上一个末尾之前，则合并
            if(cur[0] <= pre[1]) {
                pre[1] = Math.max(pre[1], cur[1]);
            } else {
                // 无重叠，直接上一个元素结果
                tempList.add(pre);

                // 更新
                pre = cur;
            }
        }

        // 加入最后一个
        tempList.add(pre);

        // 转换为 array
        int[][] results = new int[tempList.size()][2];
        for(int i = 0; i< tempList.size(); i++) {
            results[i] = tempList.get(i);
        }
        return results;
    }

}
