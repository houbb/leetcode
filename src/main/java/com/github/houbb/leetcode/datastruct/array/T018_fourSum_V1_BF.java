package com.github.houbb.leetcode.datastruct.array;

import java.util.*;

public class T018_fourSum_V1_BF {


    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();

        final int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n; k++) {
                    for(int l = k+1; l < n; l++) {
                        if(nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(list);
                            res.add(list);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }

}
