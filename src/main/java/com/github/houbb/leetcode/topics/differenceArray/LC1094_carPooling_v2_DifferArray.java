package com.github.houbb.leetcode.topics.differenceArray;

public class LC1094_carPooling_v2_DifferArray {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] differArray = new int[1001];

        for(int[] trip : trips) {
            int num = trip[0];
            int from = trip[1];
            int to = trip[2];

            differArray[from] += num;
            // 右边不包含，直接减。更加接近 LC1854
            differArray[to] -= num;
        }


        int[] ways = new int[1001];
        // 计算最大值
        ways[0] = differArray[0];
        if(ways[0] > capacity) {
            return false;
        }

        for(int i = 1; i < 1001; i++) {
            ways[i] += ways[i-1] + differArray[i];
            if(ways[i] > capacity) {
                return false;
            }
        }

        return true;
    }

}
