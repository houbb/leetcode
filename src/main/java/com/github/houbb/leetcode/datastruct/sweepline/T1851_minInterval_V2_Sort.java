package com.github.houbb.leetcode.datastruct.sweepline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T1851_minInterval_V2_Sort {

    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] resArray = new int[queries.length];

        //sort
        List<int[]> sortList = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++) {
            sortList.add(intervals[i]);
        }
        Collections.sort(sortList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < queries.length; i++) {
            int res = getInterval(sortList, queries[i]);
            resArray[i] = res;
        }
        return resArray;
    }

    private int getInterval(List<int[]> listList,
                            int query) {

        int minLen = Integer.MAX_VALUE;

        // 遍历，然后找一个最小的区间
        for(int i = 0; i < listList.size(); i++) {
            int[] range = listList.get(i);
            // 如果开始已经大于 query，直接中断
            if(query < range[0]) {
                break;
            }

            if(query <= range[1]) {
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
