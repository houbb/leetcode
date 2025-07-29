package com.github.houbb.leetcode.topics.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sort_T164_MaxGap_V7_RadixSortOptPrefixSum {


    public static int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;

        // 1. 找出最大值，用来确定最多多少位（exp 趟）
        int maxVal = nums[0];
        for (int num : nums) {
            if (num > maxVal) maxVal = num;
        }

        int n = nums.length;
        int[] aux = new int[n];   // 辅助数组，用于每一轮排序
        int exp = 1;              // 当前位的“进制权重”：1 => 个位，10 => 十位...

        while (maxVal / exp > 0) {
            int[] digitCounts = new int[10]; // 每个桶中数字出现的次数（0~9）

            // 2. 统计当前位是 0~9 的数字个数
            for (int i = 0; i < n; i++) {
                int digit = (nums[i] / exp) % 10;
                digitCounts[digit]++;
            }

            // 3. 前缀和：digitCounts[i] 表示该位 <= i 的数字个数
            int[] digitPositions = new int[10];  // 每个数字在 aux 中的起始写入位置
            digitPositions[0] = 0;
            for (int i = 1; i < 10; i++) {
                digitPositions[i] = digitPositions[i - 1] + digitCounts[i - 1];
            }

            // 4. 将 nums 中的元素稳定排序，放入 aux
            for (int i = 0; i < n; i++) {
                int digit = (nums[i] / exp) % 10;
                int pos = digitPositions[digit]++;
                aux[pos] = nums[i];
            }

            // 5. 拷贝回原数组，准备处理下一位
            System.arraycopy(aux, 0, nums, 0, n);
            exp *= 10;
        }

        // 6. 求最大间距
        int maxGap = 0;
        for (int i = 1; i < n; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }

        return maxGap;
    }

    public static void main(String[] args) {
        maximumGap(new int[]{1,10000000});
    }

}
