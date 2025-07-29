package com.github.houbb.leetcode.topics.sort;

public class Sort_T164_MaxGap_V3_CountingSort {


    public static int maximumGap(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num > max) {
                max = num;
            }
            if(num < min) {
                min = num;
            }
        }

        // 最大值和最小值相同
        if(min == max) {
            return 0;
        }

        // 创建桶
        int[] buckets = new int[max-min+1];

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            buckets[num-min]++;
        }

        // 问题就变成了寻找连续为0的桶的个数？
        int maxZeroCount = 0;
        int zeroCount = 0;
        for(int i = 0; i < buckets.length; i++) {
            if(buckets[i] != 0) {
                maxZeroCount = Math.max(zeroCount, maxZeroCount);
                // 清空
                zeroCount = 0;
            } else {
                zeroCount++;
            }
        }
        return maxZeroCount+1;
    }

    public static void main(String[] args) {
        maximumGap(new int[]{2,99999999});
    }

}
