package com.github.houbb.leetcode.topics.binarySearch;

import java.util.Arrays;

public class T4_findMedianSortedArrays_V2_MergeSort {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int totalLen = m + n;

        int i = 0, j = 0;
        int prev = 0, curr = 0;

        for (int k = 0; k <= totalLen / 2; k++) {
            prev = curr;

            // nums1 有数 && (nums2 没数了 || nums1 更小)
            if (i < m && (j >= n || nums1[i] <= nums2[j])) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }
        }

        // 如果总长度是奇数，返回当前的中位数
        if (totalLen % 2 == 1) {
            return curr;
        }

        // 如果是偶数，返回中间两个数的平均
        return (prev + curr) / 2.0;
    }

}
