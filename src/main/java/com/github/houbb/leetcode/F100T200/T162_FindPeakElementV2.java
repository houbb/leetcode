package com.github.houbb.leetcode.F100T200;

public class T162_FindPeakElementV2 {

    /**
     * 这题 test 没意思，直接 O(logn) 的效果就是 100%
     *
     * 其实，使用二分法也可以。
     *
     * 就是 3 个 case:
     *
     * 1. mid 刚好满足
     *
     * 2. mid < 左边。
     *     PEAK
     * left    mid
     *
     * 3. mid < 右边
     *     PEAK
     * mid      right
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) {
            return 0; // single element
        }

        int n = nums.length;

        // check if 0th/n-1th index is the peak element
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        // search in the remaining array
        int start = 1;
        int end = n-2;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            } else if(nums[mid] < nums[mid-1]) {
                end = mid - 1;
            } else if(nums[mid] < nums[mid+1]) {
                start = mid + 1;
            }
        }
        return -1; // dummy return statement
    }


}
