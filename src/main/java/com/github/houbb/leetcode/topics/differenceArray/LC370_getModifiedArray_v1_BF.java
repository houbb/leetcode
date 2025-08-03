package com.github.houbb.leetcode.topics.differenceArray;

import java.util.Arrays;

public class LC370_getModifiedArray_v1_BF {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] results = new int[length];
        Arrays.fill(results, 0);

        // 针对所有的数组处理
        for(int i = 0; i < updates.length; i++) {
            int[] update = updates[i];

            int start = update[0];
            int end = update[1];
            int inc = update[2];

            // 循环处理，包括2端
            for(int j = start; j <= end; j++) {
                results[j] += inc;
            }
        }

        return results;
    }

}
