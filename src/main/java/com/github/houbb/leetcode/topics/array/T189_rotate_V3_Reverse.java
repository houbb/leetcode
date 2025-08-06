package com.github.houbb.leetcode.topics.array;

import java.util.Arrays;

public class T189_rotate_V3_Reverse {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(nums));
    }


    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n <= 1) {
            return;
        }

        int mod = k % n;
        if(mod == 0) {
            return;
        }

        // 第一步：整体反转
        reverse(nums, 0, n - 1);

        // 第二步：反转前 k 个元素
        reverse(nums, 0, mod - 1);

        // 第三步：反转后 n-k 个元素
        reverse(nums, mod, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}
