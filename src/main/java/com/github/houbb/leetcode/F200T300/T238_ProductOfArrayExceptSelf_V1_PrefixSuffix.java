package com.github.houbb.leetcode.F200T300;

public class T238_ProductOfArrayExceptSelf_V1_PrefixSuffix {


    /**
     * 计算 i 前后的乘积
     *
     * 前缀乘积：prefix[i] 表示 nums[0] * nums[1] * ... * nums[i-1]
     * 后缀乘积：suffix[i] 表示 nums[i+1] * nums[i+2] * ... * nums[n-1]
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        final int len = nums.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];

        //前缀积
        prefix[0] = 1; // 第一个元素前没有其他元素，前缀积为1
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1]; // 前缀积：当前元素是前一个元素的乘积
        }

        // 后缀积
        suffix[len-1] = 1; // 最后一个元素后没有其他元素，后缀积为1
        for(int i = len-2; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }


        // 结果
        // 结果直接相乘即可
        int[] result = new int[len];
        for(int i = 0; i < len; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }

}
