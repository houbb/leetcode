package com.github.houbb.leetcode;

/**
 * 最长汇文子传
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
public class LongestPalindromicSubstringManacher {

    /**
     * 字符串预处理
     * @param s 原始字符串
     * @return 结果
     * @since v2
     */
    private String preProcess(String s) {
        int n = s.length();

        StringBuilder ret = new StringBuilder("^");
        for (int i = 0; i < n; i++) {
            ret.append("#").append(s.charAt(i));
        }
        ret.append("#$");
        return ret.toString();
    }

    // 马拉车算法

    /**
     * 效果：
     * Runtime: 8 ms, faster than 96.20% of Java online submissions for Longest Palindromic Substring.
     * Memory Usage: 39.1 MB, less than 62.76% of Java online submissions for Longest Palindromic Substring.
     *
     * @param s 原始字符串
     * @return 结果
     * @since v2
     */
    public String longestPalindrome(String s) {
        if(s.length() <= 1) {
            return s;
        }

        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0;

        // 保留结果
        int maxLen = 0;
        int centerIndex = 0;

        for (int i = 1; i < n - 1; i++) {
            int iMirror = (C << 1) - i;
            if (R > i) {
                // 防止超出 R
                P[i] = Math.min(R - i, P[iMirror]);
            } else {
                // 等于 R 的情况
                P[i] = 0;
            }

            // 碰到之前讲的三种情况时候，需要利用中心扩展法
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            // 判断是否需要更新 R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }


            // 找出最大的 P 值
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        //最开始讲的求原字符串下标
        int start = (centerIndex - maxLen) >> 1;
        return s.substring(start, start + maxLen);
    }

}
