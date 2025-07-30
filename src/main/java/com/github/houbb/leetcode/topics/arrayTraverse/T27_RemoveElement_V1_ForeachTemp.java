package com.github.houbb.leetcode.topics.arrayTraverse;

public class T27_RemoveElement_V1_ForeachTemp {

    // 直接循环一遍，找到匹配的元素
    // 前 k 个满足即可，其他的不重要
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int[] temp =  new int[nums.length];
        for(int num : nums) {
            if(num != val) {
                temp[count++] = num;
            }
        }

        // copy
        System.arraycopy(temp, 0, nums, 0, count);
        return count;
    }

}
