package com.github.houbb.leetcode.topics.binarySearch;

import java.util.Arrays;

public class T4_findMedianSortedArrays_V1_BF {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int totalLen = nums1.length+nums2.length;
        int[] nums = new int[totalLen];
        for(int num : nums1) {
            nums[i++] = num;
        }
        for(int num : nums2) {
            nums[i++] = num;
        }
        Arrays.sort(nums);

        // 单个
        int mid = totalLen / 2;
        if(totalLen % 2 == 1) {
            return nums[mid];
        }
        // 4 个数 0 1 2 3
        return (nums[mid] + nums[mid - 1])*1.0 / 2;
    }

}
