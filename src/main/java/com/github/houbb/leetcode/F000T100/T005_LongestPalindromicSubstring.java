package com.github.houbb.leetcode.F000T100;

/**
 * 最长回文子串
 * <p>
 * 限定：可假定字符串最长为 1000;
 * <p>
 * ps: 这一题最大的问题是有执行耗时的限制
 * <p>
 * 1. DP 动态规划
 * 2. Expand Around Center
 * 3. Manacher's Algorithm
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class T005_LongestPalindromicSubstring {

    /**
     * 粗暴解法
     * <p>
     * 思路：
     * <p>
     * abcdefghgfedcba
     * <p>
     * aa
     * aba
     * <p>
     * 如何判断是回文？
     *
     * <pre>
     *      list = {a, b, c, d, e, g};
     * </pre>
     * <p>
     * 回文的意思就是内容翻转之后，和原来一样。
     * <p>
     * <p>
     * 执行效果：63/113 执行超时
     *
     * @param s 字符串
     * @return 结果
     * @date 2020-6-9 20:18:59
     * @since v1
     */
    @Deprecated
    public String longestPalindrome(String s) {
        // 单个字符
        if (s.length() <= 1) {
            return s;
        }

        // sum 最长开始统计
        final int length = s.length();
        for (int sum = length; sum > 1; sum--) {
            // 这里导致有重复的信息
            int startOffset = 0;
            for (int i = startOffset; i < length; i++) {
                //0, length
                for (int j = length; j > 0; j--) {
                    if (j - i == sum) {
                        String subString = s.substring(i, j);
                        if (isPalindrome(subString)) {
                            return subString;
                        }
                    }
                    // 跳出当前循环
                    if (j - i < sum) {
                        startOffset++;
                        break;
                    }
                }
            }
        }

        return s.substring(0, 1);
    }

    /**
     * 是否为回文
     * <p>
     * aba
     * bb
     *
     * @param string 字符串
     * @return 是否
     * @since v1
     */
    public static boolean isPalindrome(final String string) {
        if (string.length() == 1) {
            return false;
        }

        final int length = string.length();
        int mid = length >> 1;

        for (int i = 0; i < mid; i++) {
            if (string.charAt(i) != string.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }

}
