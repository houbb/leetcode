package com.github.houbb.leetcode.F100T200;

public class T153_FindMinimumInRotatedSortedArrayV2 {

    /**
     * O(logn) 采用二分查找，因为是排序的，
     *
     * 问题是如果旋转了，结果还对吗？
     *
     * The minimum element must satisfy one of two conditions:
     *
     * [4,5,6,7,0,1,2]
     *
     * 1) If rotate, A[min] < A[min - 1];
     *
     * 2) If not, A[0].
     *
     * Therefore, we can use binary search: check the middle element, if it is less than previous one, then it is minimum.
     *
     * If not, there are 2 conditions as well: If it is greater than both left and right element, then minimum element should be on its right, otherwise on its left.
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = (start +end) / 2;

            // 如果是旋转的场景。不旋转的话，一定大于前面
            // [4,5,6,7,0,1,2]
            if(mid > 0 &&
                    nums[mid] < nums[mid-1]) {
                return nums[mid];
            }

            // 如果当前元素比2边都大，那就是右边。
            if(nums[mid] >= nums[start]
                && nums[mid] >= nums[end]) {
                start = mid+1;
            } else {
                end = mid-1;
            }

        }

        return nums[start];
    }

}
