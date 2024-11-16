package com.github.houbb.leetcode.datastruct.sweepline;

public class T1851_minInterval_V1_BF {

    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] resArray = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int res = getInterval(intervals, queries[i]);
            resArray[i] = res;
        }
        return resArray;
    }

    private int getInterval(int[][] intervals,
                            int query) {

        int minLen = Integer.MAX_VALUE;

        // 遍历，然后找一个最小的区间
        for(int i = 0; i < intervals.length; i++) {
            int[] range = intervals[i];
            if(query >= range[0] && query <= range[1]) {
                int len = range[1] - range[0] + 1;
                minLen = Math.min(len, minLen);
            }
        }

        if(minLen == Integer.MAX_VALUE) {
            return -1;
        }
        return minLen;
    }

}
