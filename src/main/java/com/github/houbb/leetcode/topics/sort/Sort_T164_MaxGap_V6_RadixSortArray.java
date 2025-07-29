package com.github.houbb.leetcode.topics.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sort_T164_MaxGap_V6_RadixSortArray {


    public static int maximumGap(int[] nums) {
        // 找到最大值
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        // 每一位先进先出的队列
        // 10个桶，每个桶一个队列，代表 0~9
        // 我们用数组来模拟，而不是使用这种比较重的队列
        int[][] queueList = new int[10][nums.length];
        // 记录每一个桶里面有多少个元素
        int[] queueIndexList = new int[10];

        // 从低到高开始比较，个位开始
        int exp = 1;
        // 最大的数还没结束
        while (max / exp > 0) {

            // 按照当前位放入元素？
            for(int num : nums) {
                int digit = (num / exp) % 10;   // 当前位

                // 放入对应的位置
                queueList[digit][queueIndexList[digit]++] = num;
            }

            int index = 0;
            for(int i = 0; i < 10; i++) {
                for(int j = 0; j < queueIndexList[i]; j++) {
                    // 出队列
                    nums[index++] = queueList[i][j];
                }

                // 清空数据
                queueIndexList[i] = 0;
            }

            // 进位
            exp *= 10;
        }

        // 计算
        int maxGap = 0;
        for(int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i-1]);
        }
        return maxGap;
    }

    public static void main(String[] args) {
        maximumGap(new int[]{1,10000000});
    }

}
