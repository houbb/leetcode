package com.github.houbb.leetcode.topics.differenceArray;

public class LC370_getModifiedArray_v2_DifferArray {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] differArray = new int[length];
        int[] results = new int[length];

        // 差分
        for(int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int inc = update[2];

            // start 开始+inc
            differArray[start] += inc;
            // 表示从 end + 1 开始，不再加 inc 了，要把它减回来
            if(end + 1 < length) {
                differArray[end + 1] -= inc;
            }
        }

        // 前缀和恢复
        results[0] = differArray[0];
        for(int i = 1; i < length; i++) {
            results[i] = differArray[i] + results[i-1];
        }

        return results;
    }

}
