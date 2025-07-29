package com.github.houbb.leetcode.topics.sort;

public class Sort_T164_MaxGap_V4_BucketSort {


    public static int maximumGap(int[] nums) {
        // 找到最大、最小值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        // 最大值和最小值相同
        if(min == max) {
            return 0;
        }

        // 创建桶
        int bucketSize = nums.length + 1;

        // 初始化 [min, max) 只需要记录最大值+最小值即可
        int[][] buckets = new int[bucketSize][2];
        for(int i = 0; i < bucketSize; i++) {
            buckets[i][0] = Integer.MAX_VALUE;
            buckets[i][1] = Integer.MIN_VALUE;
        }

        // 更新真实的最大、最小值
        int bucketWidth= (int) Math.ceil((double)(max-min)/ bucketSize);
        for (int num : nums) {
            int bucketIndex = (num - min) / bucketWidth;
            // 这里要处理下临界值的问题
            if(bucketIndex == bucketSize) {
                bucketIndex--;
            }

            buckets[bucketIndex][0] = Math.min(buckets[bucketIndex][0], num);
            buckets[bucketIndex][1] = Math.max(buckets[bucketIndex][1], num);
        }

        int maxGap = 0;
        int prev = min;
        for(int i = 0; i < buckets.length; i++) {
            // 跳过空桶
            if(buckets[i][0] == Integer.MAX_VALUE) {
                continue;
            }

            // 当前最小值 - 上一个最大值，得到最大的间隔
            maxGap = Math.max(maxGap, buckets[i][0] - prev);
            prev = buckets[i][1];
        }

        return maxGap;
    }

    public static void main(String[] args) {
        maximumGap(new int[]{1,10000000});
    }

}
