package com.github.houbb.leetcode.F000T100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T088_MergeSortedArray {

    /**
     * 合并
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 最后的结果放在 nums1 里面...

        List<Integer> resultList = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            resultList.add(nums1[i]);
        }
        for(int j = 0; j < n; j++) {
            resultList.add(nums2[j]);
        }

        // 排序
        Collections.sort(resultList);

        // 放在 nums1 中
        for(int i = 0; i < resultList.size(); i++) {
            nums1[i] = resultList.get(i);
        }
    }

}
