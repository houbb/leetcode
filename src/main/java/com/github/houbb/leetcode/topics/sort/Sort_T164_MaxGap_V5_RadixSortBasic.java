package com.github.houbb.leetcode.topics.sort;

import java.util.*;

public class Sort_T164_MaxGap_V5_RadixSortBasic {


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
        List<Queue<Integer>> queueList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            queueList.add(new LinkedList<>());
        }

        // 从低到高开始比较，个位开始
        int exp = 1;
        // 最大的数还没结束
        while (max / exp > 0) {
            // 按照当前位放入元素？
            for(int num : nums) {
                int digit = (num / exp) % 10;   // 当前位

                // 放入对应的位置
                queueList.get(digit).add(num);
            }

            // 按照入的顺序，出到数组中
            int index = 0;
            for(Queue<Integer> queue : queueList) {
                while (!queue.isEmpty()) {
                    nums[index++] = queue.poll();
                }
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
