package com.github.houbb.leetcode.datastruct.array;

import java.util.*;

public class T454_fourSumII_V3_HashMap {


    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        final int n = nums1.length;
        Map<Integer, Integer> sum12Map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int sum = nums1[i] + nums2[j];
                sum12Map.put(sum, sum12Map.getOrDefault(sum, 0)+1);
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int sum34 = nums3[i] + nums4[j];

                if(sum12Map.containsKey(-sum34)) {
                    count += sum12Map.get(-sum34);
                }
            }
        }

        return count;
    }

}
