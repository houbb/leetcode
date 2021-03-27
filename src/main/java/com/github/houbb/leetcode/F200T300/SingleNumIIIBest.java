package com.github.houbb.leetcode.F200T300;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class SingleNumIIIBest {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Number III.
     * Memory Usage: 39 MB, less than 82.62% of Java online submissions for Single Number III.
     *
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums) {
            xor ^= num;
        }

        // 获取非0位
        int bit = 1;
        while ((bit & xor) == 0) {
            bit <<= 1;
        }

        // 重新划分数组
        int a = 0;
        for(int num : nums) {
            if((num & bit) == 0) {
                a ^= num;
            }
        }

        // a ^ xor 就是另一个数
        return new int[]{a, a ^ xor};
    }

}
