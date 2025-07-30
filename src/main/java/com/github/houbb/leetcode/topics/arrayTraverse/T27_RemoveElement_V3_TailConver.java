package com.github.houbb.leetcode.topics.arrayTraverse;

import java.util.Arrays;

public class T27_RemoveElement_V3_TailConver {

    public int removeElement(int[] nums, int val) {
        int n = nums.length;

        int i = 0;
        while (i < n) {
            if(nums[i] == val) {
                // 尾部覆盖当前位置
                nums[i] = nums[n-1];
                n--;
            } else {
                // 向后移动
                i++;
            }
        }

        return n;
    }


    public static void main(String[] args) {
        T27_RemoveElement_V3_TailConver swap = new T27_RemoveElement_V3_TailConver();

        int[]  nums = new int[]{0,1,2,2,3,0,4,2};
        int res = swap.removeElement(nums, 2);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }

}
