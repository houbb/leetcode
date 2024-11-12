package com.github.houbb.leetcode.datastruct.array;

import java.util.*;

public class T454_fourSumII_V1_BF {


    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 暴力
        int count = 0;
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                for(int k = 0; k < nums3.length; k++) {
                    for(int l = 0; l < nums4.length; l++) {
                        int sum = nums1[i] + nums2[j] + nums3[k] + nums4[l];
                        if(sum == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

}
