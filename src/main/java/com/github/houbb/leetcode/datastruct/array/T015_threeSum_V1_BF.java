package com.github.houbb.leetcode.datastruct.array;

import java.util.*;
import java.util.stream.Collectors;

public class T015_threeSum_V1_BF {


    /**
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();

        final int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n; k++) {
                    if(nums[i]+nums[j]+nums[k] == 0) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list);
                        res.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }

}
