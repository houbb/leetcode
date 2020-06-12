package com.github.houbb.leetcode;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class PalindromeNumberOptimize {

    /**
     * 最佳解法
     *
     * 【效果】
     *
     * @param x 数字
     * @return 结果
     * @since best
     */
    public boolean isPalindrome(int x) {
        int temp = x;
        int ds = 0;
        while (temp > 0) {
            // 直接反向操作，计算逆序的数值
            ds = ds * 10 + (temp % 10);

            // 保留的高位
            temp /= 10;
        }

        return (x - ds) == 0;
    }

    /**
     * 优化思路
     * <p>
     * 可以使用字符串，中间往两边均摊的方法。
     * <p>
     * Runtime: 7 ms, faster than 76.19% of Java online submissions for Palindrome Number.
     * Memory Usage: 38.5 MB, less than 92.10% of Java online submissions for Palindrome Number.
     *
     * @param x 数字
     * @return 结果
     * @since v1
     */
    public boolean isPalindrome2(int x) {
        String string = String.valueOf(x);
        final int length = string.length();
        int mid = length >> 1;

        // 从中间往两边均摊
        for (int i = 0; i < mid; i++) {
            if (string.charAt(i) != string.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
