package com.github.houbb.leetcode.F000T100;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T026_RemoveDuplicatesFromSortedArray {

    /**
     * 思路
     *
     * 1. 返回的结果要对
     * 2. 返回的长度对应的数组要唯一。
     *
     * 【效果】
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array.
     * Memory Usage: 41.3 MB, less than 59.78% of Java online submissions for Remove Duplicates from Sorted Array.
     *
     * @param nums 数组
     * @return 结果
     * @since v1
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            // 将后面不同的元素复制过来
            if (i == 0 || n > nums[i-1]) {
                nums[i++] = n;
            }
        }
        return i;
    }

}
