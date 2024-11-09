package com.github.houbb.leetcode.datastruct.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T220_ContainsDup_V2_SlideWindowAndSort {

    public static void main(String[] args) {
        T220_ContainsDup_V2_SlideWindowAndSort sort = new T220_ContainsDup_V2_SlideWindowAndSort();

        boolean falg = sort.containsNearbyAlmostDuplicate(new int[]{4,1,6,3}, 4, 1);
        System.out.println(falg);
    }

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

        List<Integer> copyList = new ArrayList<>(valueList);
        Collections.sort(copyList);

        // 排序之后，如何才能避免全部循环一遍查找结果呢？
        // 二分法 YYDS
        int left = 0;
        int right = copyList.size()-1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int differ = Math.abs(copyList.get(mid)- num);
            if(differ <= valueDiffer) {
                return true;
            }

            // 向左还是向右？
            if(copyList.get(mid) < num) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return false;
    }

}
