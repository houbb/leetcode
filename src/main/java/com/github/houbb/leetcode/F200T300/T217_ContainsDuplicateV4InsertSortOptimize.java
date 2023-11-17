package com.github.houbb.leetcode.F200T300;

/**
 * 是否存在重复元素
 *
 * @since 20231117
 */
public class T217_ContainsDuplicateV4InsertSortOptimize {

    public boolean containsDuplicate(int[] nums) {
        int current = 0;
        for (int i = 1; i < nums.length; i++) {
            current = nums[i];

            if(current > nums[i-1]) {
                continue;
            }
            if(current == nums[i-1]) {
                return true;
            }

            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (current < nums[mid]) {
                    high = mid - 1;
                } else if (current > nums[mid]) {
                    low = mid + 1;
                } else {
                    return true;
                }
            }

            // 使用 Arrays.copyOfRange 方法替代逐个移动
            if (i > low) {
                System.arraycopy(nums, low, nums, low + 1, i - low);
            }
            nums[low] = current;
        }

        return false;
    }

}
