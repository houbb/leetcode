package com.github.houbb.leetcode.topics.arrayTraverse;

import java.util.Arrays;

public class T27_RemoveElement_V2_ForeachSwap {



    // 直接循环一遍，找到匹配的元素
    // 前 k 个满足即可，其他的不重要
    // 移动的代价比较大，还是交换比较合适一些
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] != val) {
                count++;
            } else {
                // 找到下一个不等于
                int nextIndex = findNotEqualValIndex(nums, val, i+1);
                if(nextIndex == -1) {
                    return count;
                }

                // 交换
                swap(nums, i, nextIndex);
                count++;
            }
        }

        return count;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int findNotEqualValIndex(int[] nums, int val, int startIx) {
        // 越界
        if(startIx >= nums.length) {
            return -1;
        }

        for(int i = startIx; i < nums.length; i++) {
            if(nums[i] != val) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        T27_RemoveElement_V2_ForeachSwap swap = new T27_RemoveElement_V2_ForeachSwap();

        int[]  nums = new int[]{0,1,2,2,3,0,4,2};
        int res = swap.removeElement(nums, 2);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }

}
