package com.github.houbb.leetcode.F000T100;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T026_RemoveDuplicatesFromSortedArrayV2 {

    /**
     * 思路
     *
     * 1. 返回的结果要对
     * 2. 返回的长度对应的数组要唯一。
     *
     * @param nums 数组
     * @return 结果
     * @since v1
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            // 前兩個元素不用考慮
            // 大于上一个，或者等于上一个且大于上上个
            if ((i == 0 || i == 1) || (n > nums[i-1] || (n > nums[i-2] && n == nums[i-1]))) {
                nums[i++] = n;
            }
        }
        return i;
    }

}
