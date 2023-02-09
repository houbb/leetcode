package com.github.houbb.leetcode.F000T100;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T009_PalindromeNumberV1 {

    /**
     * Runtime: 7 ms, faster than 76.19% of Java online submissions for Palindrome Number.
     * Memory Usage: 39.3 MB, less than 22.45% of Java online submissions for Palindrome Number.
     *
     * @param x 数字
     * @return 结果
     * @since v1
     */
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        // 反转
        int reverse = reverse(x);
        return x == reverse;
    }

    private int reverse(int x) {
        int result = 0;

        while (x != 0) {
            // 移除最后一位
            int pop = x % 10;
            x = x / 10;

            // 返回值
            result = result * 10 + pop;
        }
        return result;
    }

}
