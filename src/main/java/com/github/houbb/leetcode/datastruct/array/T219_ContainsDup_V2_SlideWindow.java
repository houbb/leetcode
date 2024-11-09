package com.github.houbb.leetcode.datastruct.array;

import java.util.*;

public class T219_ContainsDup_V2_SlideWindow {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){

            // 固定窗口大小
            if(i > k) {
                // 移除最开始的元素  保证窗口最多k
                set.remove(nums[i - k - 1]);
            }

            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        return false;
    }


}
