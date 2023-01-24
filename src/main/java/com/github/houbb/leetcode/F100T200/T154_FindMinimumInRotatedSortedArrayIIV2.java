package com.github.houbb.leetcode.F100T200;

public class T154_FindMinimumInRotatedSortedArrayIIV2 {

    /**
     * 二分法
     *
     * First, we take
     * low (lo) as 0
     * high (hi) as nums.length-1
     *
     * 0 1 2 3 4
     *
     * By default, if nums[lo]<nums[hi] then we return nums[lo] because the array was never rotated, or is rotated n times
     *
     * After entering while loop, we check
     * if nums[mid] > nums[hi] => lo = mid + 1 because the minimum element is in the right half of the array
     *
     * 2 3 4 0 1
     *
     * else if nums[mid] < nums[hi] => hi = mid because the minimum element is in the left half of the array
     *
     * 7 0 1 2 3 4 5 6
     *
     * else => hi-- dealing with duplicate values
     * then we return nums[hi]
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;

        // default
        if(nums[low] < nums[high]) {
            return nums[low];
        }

        while (low < high) {
            int mid = (low + high) / 2;

            //1. 大于最大,在右边
            if(nums[mid] > nums[high]) {
                low = mid+1;
            } else if(nums[mid] < nums[high]) {
                //2. 小于最大，则在左边
                high = mid;
            } else {
                // 重复
                high--;
            }
        }

        return nums[high];
    }

}
