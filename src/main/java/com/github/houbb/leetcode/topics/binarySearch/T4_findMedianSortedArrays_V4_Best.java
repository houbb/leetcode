package com.github.houbb.leetcode.topics.binarySearch;

public class T4_findMedianSortedArrays_V4_Best {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        if (totalLen % 2 == 1) {
            // 奇数，返回第 (totalLen / 2 + 1) 小的数
            return getKthElement(nums1, nums2, totalLen / 2 + 1);
        } else {
            // 偶数，返回中间两个数的平均
            int left = getKthElement(nums1, nums2, totalLen / 2);
            int right = getKthElement(nums1, nums2, totalLen / 2 + 1);
            return (left + right) / 2.0;
        }
    }

    // 寻找两个有序数组中的第 k 小的元素（k 从 1 开始）
    private int getKthElement(int[] nums1, int[] nums2, int k) {
        int index1 = 0, index2 = 0;
        int len1 = nums1.length, len2 = nums2.length;

        while (true) {
            // 边界情况
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况，比较第 k/2 个元素
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;

            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];

            if (pivot1 <= pivot2) {
                // 舍弃 nums1 的前 half 个元素
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                // 舍弃 nums2 的前 half 个元素
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

}
