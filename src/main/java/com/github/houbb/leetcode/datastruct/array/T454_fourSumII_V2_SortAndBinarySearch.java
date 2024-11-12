package com.github.houbb.leetcode.datastruct.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T454_fourSumII_V2_SortAndBinarySearch {


    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        final int n = nums1.length;
        List<Integer> sum_12 = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sum_12.add(nums1[i] + nums2[j]);
            }
        }
        List<Integer> sum_34 = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sum_34.add(nums3[i] + nums4[j]);
            }
        }
        // 排序，便于二分
        Collections.sort(sum_34);

        int count = 0;
        for(int i = 0; i < sum_12.size(); i++) {
            int target = -sum_12.get(i);
            count += binaryCount(sum_34, target);
        }
        return count;
    }


    // 找到所有匹配的数据
    private int binaryCount(List<Integer> sum_34,
                            int target) {
        int left = 0;
        int right = sum_34.size()-1;
        int count = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int val = sum_34.get(mid);
            if(val == target) {
                count++;
                // 向左找
                int leftIx = mid-1;
                while (leftIx >= 0 && sum_34.get(leftIx) == val) {
                    count++;
                    leftIx--;
                }
                // 向右找
                int rightIx = mid+1;
                while (rightIx < sum_34.size() && sum_34.get(rightIx) == val) {
                    count++;
                    rightIx++;
                }
            }

            // 迭代位置
            if(val < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return count;
    }

}
