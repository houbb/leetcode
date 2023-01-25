package com.github.houbb.leetcode.F100T200;

import java.util.Arrays;

public class T167_TwoSumIIInputArrayIsSortedV3 {

    public static void main(String[] args) {
        T167_TwoSumIIInputArrayIsSortedV3 sortedV2 = new T167_TwoSumIIInputArrayIsSortedV3();

        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(sortedV2.twoSum(nums, 9)));
    }

    /**
     * 双指针
     * <p>
     * 通过二分法查找，把整体使用二分法查找。
     *
     * 妙！
     * @param numbers 数组
     * @param target  结果
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numbers[low] + numbers[high] == target) {
                break;
            } else if (numbers[low] + numbers[high] < target) {
                low = numbers[mid] + numbers[high] < target ? mid : low + 1;
            } else {
                high = numbers[mid] + numbers[low] > target ? mid : high - 1;
            }
        }
        return new int[]{low + 1, high + 1};
    }

}
