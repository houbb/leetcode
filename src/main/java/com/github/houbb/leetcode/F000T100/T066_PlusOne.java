package com.github.houbb.leetcode.F000T100;

import java.util.Arrays;

public class T066_PlusOne {

    /**
     * 思路：
     *
     * 1. 首先把 int 计算出来？能计算吗？
     *
     * 1 <= digits.length <= 100
     *
     * 如果直接计算，应该会 overflow。
     *
     * 【递进】
     * 1. 直接从最后一位开始，然后 +1
     *
     * 2. 直接利用进 1 的规则
     */
    public int[] plusOne(int[] digits) {
        // 不需要进位
        int lastNum = digits[digits.length-1];
        if(0 <= lastNum
                && lastNum <= 8) {
            digits[digits.length-1] = digits[digits.length-1] + 1;
            return digits;
        }

        // 最后一位是 9 的话
        // 从倒数第二位开始累加。
        // 是否需要第一位 + 1？？
        boolean needAddOne = true;
        for(int i = digits.length-1; i >= 0; i--) {
            // 当前位置+1
            // 如果当前位置为9，则+1
            int num = digits[i];
            if(needAddOne) {
                num++;
            }

            // 如果等于10
            if(num == 10) {
                digits[i] = 0;
                // 进1位
                needAddOne = true;
            } else {
                digits[i] = num;
                needAddOne = false;
            }
        }

        // 最后一个是否需要进位
        if(!needAddOne) {
            return digits;
        }

        // 可能需要新增1位的，最后统一处理。首字母为1
        int[] results = new int[digits.length+1];
        // 首位
        results[0] = 1;
        // 可以复制拷贝，也可以逐步插入。不处理也行，因为 num 默认为 0
        return results;
    }

    public static void main(String[] args) {
        int[] nums = new int[2];
        nums[0] = 1;

        System.out.println(Arrays.toString(nums));
    }

}
