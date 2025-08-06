package com.github.houbb.leetcode.topics.array;

public class T238_productExceptSelf_V1_BF {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] results = new int[n];

        // 计算全部的乘积
        int sumMulti = 1;
        int zeroCount = 0;
        for(int num : nums) {
            if(num == 0) {
                zeroCount++;
            } else {
                sumMulti *= num;
            }
        }

        // 结果
        for(int i = 0; i < n; i++) {
            // 超过1个0，全是0
            if(zeroCount > 1) {
                results[i] = 0;
            } else if(zeroCount == 1 && nums[i] != 0) {
                results[i] = 0;
            } else if(zeroCount == 1 && nums[i] == 0) {
                results[i] = sumMulti;
            } else {
                results[i] = sumMulti / nums[i];
            }
        }
        return results;
    }

}
