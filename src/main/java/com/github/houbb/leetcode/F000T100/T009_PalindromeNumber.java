package com.github.houbb.leetcode.F000T100;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T009_PalindromeNumber {

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
    public boolean isPalindrome(int x) {
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
