package com.github.houbb.leetcode.topics.array;

import java.util.Arrays;

public class T189_rotate_V4_Cycle {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(nums));
    }


    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = 0;  // 记录被移动元素的总数

        for (int start = 0; count < n; start++) {
            int current = start;
            int prev = nums[start];

            do {
                int next = (current + k) % n;
                int temp = nums[next];

                nums[next] = prev;
                prev = temp;
                current = next;

                count++;
            } while (start != current); // 环结束
        }
    }

}
