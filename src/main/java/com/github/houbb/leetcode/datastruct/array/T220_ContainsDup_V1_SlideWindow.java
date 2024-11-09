package com.github.houbb.leetcode.datastruct.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T220_ContainsDup_V1_SlideWindow {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        List<Integer> valueList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            // 固定窗口大小
            if(i > indexDiff) {
                // 移除最开始的元素
                valueList.remove(0);
            }

            // 判断是否满足条件
            if(isValueMatch(valueList, nums[i], valueDiff)) {
                return true;
            }
            valueList.add(nums[i]);
        }

        return false;
    }

    public boolean isValueMatch(List<Integer> valueList,
                                int num,
                                int valueDiffer) {
        if(valueList.size() <= 0) {
            return false;
        }

        // 比较差值
        for(int v : valueList) {
            if(Math.abs(v-num) <= valueDiffer) {
                return true;
            }
        }
        return false;
    }

}
