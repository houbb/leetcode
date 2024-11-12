package com.github.houbb.leetcode.datastruct.array;

import java.util.Arrays;

public class T454_fourSumII_V3_HashMapAndComparess {


    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int[] n1 = getMaxMin(nums1);
        int[] n2 = getMaxMin(nums2);
        int[] n3 = getMaxMin(nums3);
        int[] n4 = getMaxMin(nums4);
        int maxSum = Math.max(n1[0] + n2[0], -n3[1] - n4[1]);
        int minSum = Math.min(n1[1] + n2[1], -n3[0] - n4[0]);
        int[] map = new int[maxSum - minSum + 1];
        for (int i : nums1) {
            for (int j : nums2) {
                map[i + j - minSum] ++ ;
            }
        }
        int count = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                count += map[- i - j - minSum];
            }
        }
        return count;
    }
    public int[] getMaxMin (int[] nums) {
        int[] num = Arrays.copyOf(nums, nums.length);
        Arrays.sort(num);
        int min = num[0];
        int max = num[nums.length - 1];
        return new int[] {max, min};
    }

}
