package com.github.houbb.leetcode.datastruct.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class T220_ContainsDup_V3_SlideWindowAndTreeSet {

    public static void main(String[] args) {
        T220_ContainsDup_V3_SlideWindowAndTreeSet sort = new T220_ContainsDup_V3_SlideWindowAndTreeSet();

        boolean falg = sort.containsNearbyAlmostDuplicate(new int[]{4,1,6,3}, 4, 1);
        System.out.println(falg);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // 使用 TreeSet 来维护滑动窗口，元素会自动排序
        TreeSet<Integer> window = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果窗口大小超过 indexDiff，移除最旧的元素
            if (i > indexDiff) {
                window.remove(nums[i - indexDiff - 1]);
            }
            // 查找当前元素是否满足条件：存在一个元素在当前窗口内，且差值不超过 valueDiff
            Integer floor = window.floor(nums[i] + valueDiff);  // 查找小于等于 nums[i] + valueDiff 的最大元素
            if (floor != null && Math.abs(floor - nums[i]) <= valueDiff) {
                return true;
            }
            Integer ceiling = window.ceiling(nums[i] - valueDiff);  // 查找大于等于 nums[i] - valueDiff 的最小元素
            if (ceiling != null && Math.abs(ceiling - nums[i]) <= valueDiff) {
                return true;
            }
            // 将当前元素加入到窗口中
            window.add(nums[i]);
        }
        return false;
    }

}
