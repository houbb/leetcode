package com.github.houbb.leetcode.F000T100;

/**
 * @author d
 * @since 1.0.0
 */
public class T035_SearchInsertPosition {

    /**
     * 先处理 O(n) 的方式，直接遍历，很简单
     *
     * 100%，老实说，这一题的测试用例没有区分度。
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            int value = nums[i];

            if(target == value) {
                return i;
            }

            if(target < value) {
                return i;
            }
        }

        // 放在最后
        return nums.length;
    }

}
