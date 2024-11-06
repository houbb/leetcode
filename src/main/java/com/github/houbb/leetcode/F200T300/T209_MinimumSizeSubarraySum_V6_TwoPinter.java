package com.github.houbb.leetcode.F200T300;

public class T209_MinimumSizeSubarraySum_V6_TwoPinter {

    /**
     * 使用 slide window 实现
     *
     * 1. step 从 1 到 len
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;  // 用于存储最小子数组长度
        int sum = 0;  // 当前窗口的和
        int left = 0;  // 左指针

        for (int right = 0; right < n; right++) {
            // 扩展窗口，加入当前右指针的元素
            sum += nums[right];

            // 当窗口和大于等于 target 时，尝试缩小窗口
            // 因为要保证 sum >= target，所以可以同时保证 left 和 right 的位置相对正确。
            // 这是一种比较巧妙的解法。
            while (sum >= target) {
                // 更新最小长度
                minLength = Math.min(minLength, right - left + 1);

                // 缩小窗口，移除左端元素
                sum -= nums[left];
                left++;
            }
        }

        // 如果没有找到符合条件的子数组，返回 0
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

}
