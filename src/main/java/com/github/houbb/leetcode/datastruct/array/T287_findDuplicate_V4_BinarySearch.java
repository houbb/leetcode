package com.github.houbb.leetcode.datastruct.array;

public class T287_findDuplicate_V4_BinarySearch {

    public int findDuplicate(int[] nums) {
        //对 数值范围 [1, n] 进行二分
        int left = 1;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right-left) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }

            // 如果个数 > mid，说明重复数在左边。
            if(count > mid) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }


}
