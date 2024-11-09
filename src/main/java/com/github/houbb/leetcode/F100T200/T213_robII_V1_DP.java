package com.github.houbb.leetcode.F100T200;

import java.util.Arrays;

public class T213_robII_V1_DP {


    public static void main(String[] args) {
        T213_robII_V1_DP dp = new T213_robII_V1_DP();

        dp.rob(new int[]{1,2,3,1});
    }

    /**
     * 每一个房间都有 2 个选择：偷还是不偷。
     *
     * 可以拆分为两个数组。
     *
     * rob[] 偷当前的房间
     * notRob[] 不偷当前的房间
     *
     *
     * ### 初始化
     *
     * ```
     * // 第一个房间选择偷，财富默认为第一个房间
     * rob[0] = nums[0];
     * // 第一个房间选择不偷，财富默认为0
     * notRob[0] = 0;
     * ```
     *
     * 递推公式：
     *
     * // 当前的房间为 i
     * // 如果当前房间选择偷 那么上一个房间一定不能偷，否则会触发报警。
     * // 上一次选择偷的房间是 rob[i-2]
     *
     * 这一次是选择偷呢？还是不偷呢？
     *
     * ```java
     * // 选择偷
     * // 1. 上一个房间必须不能偷+当前的
     * // a. 上一个房间没偷的+当前
     * // b. 上一个房间偷的对比
     * rob[i] = Math.max(notRob[i-1]+nums[i], rob[i-1]);
     *
     * // 选择不偷
     * //2. 不偷有两种可能性
     * //2.a 上一个房间没偷
     * //2.b 上一个房间偷了
     * notRob[i] = Math.max(notRob[i-1], rob[i-1]);
     * ```
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        // 拆分为两个场景
        // 0 ... n-2
        // 1 ... n-1
        final int n = nums.length;
        int maxZero = robAll(Arrays.copyOfRange(nums, 0, n-1));
        int maxOne = robAll(Arrays.copyOfRange(nums, 1, n));
        return Math.max(maxOne, maxZero);
    }

    public int robAll(int[] nums) {
        final int n = nums.length;
        int rob[] = new int[n];
        int notRob[] = new int[n];

        rob[0] = nums[0];
        notRob[0] = 0;

        // 遍历
        // 这里其实已经固定选择偷第一个了
        int maxResult = nums[0];
        for(int i = 1; i < n; i++) {
            // 选择偷
            // 1. 上一个房间必须不能偷+当前的
            // a. 上一个房间没偷的+当前
            // b. 上一个房间偷的对比
            rob[i] = Math.max(notRob[i-1]+nums[i], rob[i-1]);

            // 选择不偷
            //2. 不偷有两种可能性
            //2.a 上一个房间没偷
            //2.b 上一个房间偷了
            notRob[i] = Math.max(notRob[i-1], rob[i-1]);

            // 取最大值
            maxResult = Math.max(rob[i], notRob[i]);
        }
        return maxResult;
    }

}
