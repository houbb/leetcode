package com.github.houbb.leetcode.F000T100;

/**
 * @author d
 * @since 1.0.0
 */
public class T0531_MaximumSubarray {

    /**
     * dp
     *
     * 1. dp[n] 的数组
     * 初始化：
     * dp[0] = nums[0]
     * max = nums[0];
     *
     * 2. 遍历，从 1 到最后
     *
     * dp[i] = Math.max(dp[i-1] + nums[i], dp[i-1]);
     * max = Math.max(max, dp[i]);
     *
     * https://leetcode.com/problems/maximum-subarray/solutions/1595195/c-python-7-simple-solutions-w-explanation-brute-force-dp-kadane-divide-conquer/
     *
     * @param nums 数组
     * @return 结果
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];

        for(int i = 1; i < nums.length; i++) {
            // 如果当前 dp[i - 1] > 0，则可以继续加上。如果不是，当前 i 直接作为新的子节点
            dp[i] = nums[i] + Math.max(dp[i - 1], 0);

            // 对比 max
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
