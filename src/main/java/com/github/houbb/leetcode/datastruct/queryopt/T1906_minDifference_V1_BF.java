package com.github.houbb.leetcode.datastruct.queryopt;

public class T1906_minDifference_V1_BF {


    public int[] minDifference(int[] nums, int[][] queries) {
        final int len = queries.length;
        int[] res = new int[len];
        for(int i = 0; i < len; i++) {
            int[] query = queries[i];
            res[i] = getMinAbs(nums, query);
        }
        return res;
    }

    private int getMinAbs(final int[] num, final int[] query) {
        // 计算范围内任意两个数的最小值
        int minAbs = Integer.MAX_VALUE;

        int startIx = query[0];
        int endIx = query[1];

        for(int i = startIx; i <= endIx-1; i++) {
            for(int j = i+1; j <= endIx; j++) {
                // 如果相等
                if(num[i] == num[j]) {
                    continue;
                }
                int abs = Math.abs(num[i] - num[j]);
                minAbs = Math.min(abs, minAbs);
            }
        }

        if(minAbs != Integer.MAX_VALUE) {
            return minAbs;
        }

        return -1;
    }

}
