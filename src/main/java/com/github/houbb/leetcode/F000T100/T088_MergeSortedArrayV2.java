package com.github.houbb.leetcode.F000T100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T088_MergeSortedArrayV2 {

    /**
     * 合并
     *
     * 优化思路：
     *
     * 1. n1, n2 本身都是严格顺序的。
     *
     * 2. 直接定义 p1, p2 指针，移动对比
     *
     * 选择较小的放在结果中，不需要排序。
     *
     * @param nums1 数组1
     * @param m 个数1
     * @param nums2 数组2
     * @param n 个数2
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 最后的结果放在 nums1 里面...

        List<Integer> resultList = new ArrayList<>(m+n);
        int p1 = 0;
        int p2 = 0;

        while (p1 < m
            && p2 < n) {
            if(nums1[p1] <= nums2[p2]) {
                resultList.add(nums1[p1]);
                p1++;
            } else {
                resultList.add(nums2[p2]);
                p2++;
            }
        }

        // 剩余的部分，一般而言，其实只会剩余一个
        while (p1 < m) {
            resultList.add(nums1[p1]);
            p1++;
        }
        while (p2 < n) {
            resultList.add(nums2[p2]);
            p2++;
        }

        // 放在 nums1 中
        for(int i = 0; i < resultList.size(); i++) {
            nums1[i] = resultList.get(i);
        }
    }

}
