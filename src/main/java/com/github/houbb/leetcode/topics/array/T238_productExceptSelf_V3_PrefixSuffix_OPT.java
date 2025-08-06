package com.github.houbb.leetcode.topics.array;

public class T238_productExceptSelf_V3_PrefixSuffix_OPT {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;

        int[] results = new int[n];

        for(int i = 0; i < n; i++) {
            results[i] = prefix;

            prefix *= nums[i];
        }

        for(int i = n-1; i >= 0; i--) {
            results[i] *= suffix;
            suffix *= nums[i];
        }

        return results;
    }

}
