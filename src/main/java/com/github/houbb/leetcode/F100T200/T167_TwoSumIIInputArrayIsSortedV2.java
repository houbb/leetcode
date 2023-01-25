package com.github.houbb.leetcode.F100T200;

import java.util.Arrays;

public class T167_TwoSumIIInputArrayIsSortedV2 {

    public static void main(String[] args) {
        T167_TwoSumIIInputArrayIsSortedV2 sortedV2 = new T167_TwoSumIIInputArrayIsSortedV2();

        int[] nums = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(sortedV2.twoSum(nums, 9)));
    }

    /**
     * 双指针
     *
     * 通过二分法查找。
     *
     *
     * @param numbers 数组
     * @param target 结果
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        // 永远有一个解
        int[] result = new int[2];

        for(int i = 0; i < numbers.length-1; i++) {
            // 因为结果是排序好的，越来越大
            int cur = numbers[i];
            int j = binarySearch(i+1, numbers, target - cur);

            if(j >= i) {
                result[0] = i+1;
                result[1] = j+1;
                return result;
            }
        }

        return result;
    }

    /**
     * 二分查找
     * @param startIndex 开始下标
     * @param nums 数组
     * @param target 目标值
     * @return 结果
     */
    private int binarySearch(int startIndex, int[] nums, int target) {
        int low = startIndex;
        int high = nums.length-1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int midVal = nums[mid];
            if(midVal == target) {
                return mid;
            } else if(midVal > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }


        // 未找到
        return -1;
    }


}
