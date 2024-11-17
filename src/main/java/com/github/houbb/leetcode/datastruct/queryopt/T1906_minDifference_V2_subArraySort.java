package com.github.houbb.leetcode.datastruct.queryopt;

import java.util.Arrays;

public class T1906_minDifference_V2_subArraySort {


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

        // 子数组排序
        // 获取子数组 nums[l...r]
        int[] subArray = Arrays.copyOfRange(num, startIx, endIx + 1);

        // 对子数组进行排序
        Arrays.sort(subArray);

        boolean allEqual = true;
        for (int j = 1; j < subArray.length; j++) {
            // 如果有不同的元素，更新最小差值
            if (subArray[j] != subArray[j - 1]) {
                allEqual = false;
                minAbs = Math.min(minAbs, Math.abs(subArray[j] - subArray[j - 1]));
            }
        }

        if(allEqual) {
            return -1;
        }

        return minAbs;
    }

}
