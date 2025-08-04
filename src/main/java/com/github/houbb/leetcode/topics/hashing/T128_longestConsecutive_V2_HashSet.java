package com.github.houbb.leetcode.topics.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T128_longestConsecutive_V2_HashSet {

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1,2};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        if(nums.length <= 0) {
            return 0;
        }

        // 初始化
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        // 再遍历一次
        int maxLen = 1;

        for(int num : set) {
            // 没有比当前数小的，那么只要看刚好大1的连续个数就行
            if(!set.contains(num-1)) {
                int curNum = num;
                int curLen = 1;
                while (set.contains(curNum+1)) {
                    curNum++;
                    curLen++;
                }

                maxLen = Math.max(curLen, maxLen);
            }
        }

        return maxLen;
    }

}
