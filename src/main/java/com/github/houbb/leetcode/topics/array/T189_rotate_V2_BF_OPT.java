package com.github.houbb.leetcode.topics.array;

import java.util.Arrays;

public class T189_rotate_V2_BF_OPT {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums,3);

        System.out.println(Arrays.toString(nums));
    }


    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n <= 1) {
            return;
        }

        int mod = k % n;
        if(mod == 0) {
            return;
        }

        // 如何移动
        int[] temp = new int[mod];
        System.arraycopy(nums, n-mod, temp, 0, mod);

        // 前面的向后移动k位
        System.arraycopy(nums, 0, nums, mod, n-mod);

        // temp 放在前面
        System.arraycopy(temp, 0, nums, 0, mod);
    }


}
