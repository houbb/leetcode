package com.github.houbb.leetcode.F200T300;

public class T238_ProductOfArrayExceptSelf_V2_PrefixSuffixMemOpt {


    /**
     * 计算 i 前后的乘积
     *
     * 前缀乘积：prefix[i] 表示 nums[0] * nums[1] * ... * nums[i-1]
     * 后缀乘积：suffix[i] 表示 nums[i+1] * nums[i+2] * ... * nums[n-1]
     *
     * 内存优化的思路：直接用一个变量存储对应的值，而不是数组。
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        final int len = nums.length;
        int[] answer = new int[len];

        //前缀积
        // 计算前缀乘积并存储在answer数组中
        int prefix = 1;
        for (int i = 0; i < len; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }

        // 后缀积
        int suffix = 1; // 最后一个元素后没有其他元素，后缀积为1
        for(int i = len-2; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            suffix *= nums[i];
        }

        return answer;
    }

}
