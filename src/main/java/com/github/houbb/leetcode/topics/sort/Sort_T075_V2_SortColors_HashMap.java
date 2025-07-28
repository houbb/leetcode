package com.github.houbb.leetcode.topics.sort;

import java.util.HashMap;
import java.util.Map;

public class Sort_T075_V2_SortColors_HashMap {

    /**
     * 最简单的就是分组：
     * 1. 直接计数排序
     * 2.
     * @param nums 数组
     */
    public void sortColors(int[] nums) {
        // 0、 1 和 2 分别表示红色、白色和蓝色。
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, ++count);
        }

        // 输出
        int i = 0;
        int count0 = map.getOrDefault(0, 0);
        while (count0 > 0) {
            nums[i++] = 0;
            count0--;
        }
        int count1 = map.getOrDefault(1, 0);
        while (count1 > 0) {
            nums[i++] = 1;
            count1--;
        }
        int count2 = map.getOrDefault(2, 0);
        while (count2 > 0) {
            nums[i++] = 2;
            count2--;
        }
    }

}
