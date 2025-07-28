package com.github.houbb.leetcode.topics.sort;

public class Sort_T075_V1_SortColors_countingSort {

    /**
     * 最简单的就是分组：
     * 1. 直接计数排序
     * 2.
     * @param nums 数组
     */
    public void sortColors(int[] nums) {
        // 0、 1 和 2 分别表示红色、白色和蓝色。
        int[] tempList = new int[3];
        for(int num : nums) {
            int count = tempList[num];
            tempList[num] = ++count;
        }

        // 输出
        int i = 0;
        int count0 = tempList[0];
        while (count0 > 0) {
            nums[i++] = 0;
            count0--;
        }
        int count1 = tempList[1];
        while (count1 > 0) {
            nums[i++] = 1;
            count1--;
        }
        int count2 = tempList[2];
        while (count2 > 0) {
            nums[i++] = 2;
            count2--;
        }
    }
}
