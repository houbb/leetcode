package com.github.houbb.leetcode.topics.differenceArray;

public class LC1094_carPooling_v1_BF {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] ways = new int[1001];

        for(int[] trip : trips) {
            int num = trip[0];
            int from = trip[1];
            int to = trip[2];


            // 包含右边吗？
            for(int i = from; i < to; i++) {
                ways[i] += num;
            }
        }

        // 计算最大值
        for(int i = 0; i < 1001; i++) {
            if(ways[i] > capacity) {
                return false;
            }
        }

        return true;
    }

}
