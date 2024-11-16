package com.github.houbb.leetcode.datastruct.sweepline;

import java.util.*;

public class T1851_minInterval_V3_queryPreSort_queryOpt {

    public int[] minInterval(int[][] intervals, int[] queries) {
        // 将查询的值与原始索引配对，方便结果按查询顺序返回
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = -1;  // 初始化为-1
        }

        // 1. 对区间按左端点排序，如果左端点相同则按右端点排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. 对查询进行排序，并记录原来的索引
        int[][] queriesWithIndex = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            queriesWithIndex[i] = new int[]{queries[i], i};
        }
        Arrays.sort(queriesWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        // 3. 使用最小堆维护区间
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])); // 堆按区间长度排序

        int idx = 0;  // 区间数组的下标
        // 4. 遍历查询并处理每个查询
        for (int[] query : queriesWithIndex) {
            int q = query[0];  // 当前查询值
            int queryIdx = query[1];  // 当前查询的原始索引

            // 5. 将所有左端点小于等于当前查询值的区间加入堆
            while (idx < intervals.length && intervals[idx][0] <= q) {
                int left = intervals[idx][0], right = intervals[idx][1];
                minHeap.offer(new int[]{right - left + 1, right, left});
                idx++;
            }

            // 6. 移除堆中不再覆盖当前查询值的区间
            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }

            // 7. 如果堆不为空，说明有有效区间覆盖当前查询值
            // 这里直接取到的第一个，就是最小的区间
            if (!minHeap.isEmpty()) {
                result[queryIdx] = minHeap.peek()[0];
            }
        }

        return result;
    }

}
