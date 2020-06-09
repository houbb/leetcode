package com.github.houbb.leetcode;

/**
 * 最长汇文子传
 *
 * 限定：可假定字符串最长为 1000;
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class LongestPalindromicSubstring {

    /**
     * 粗暴解法
     *
     * 思路：
     *
     * abcdefghgfedcba
     *
     * aa
     * aba
     *
     * 如何判断是回文？
     *
     * <pre>
     *      list = {a, b, c, d, e, g};
     * </pre>
     *
     * 回文的意思就是内容翻转之后，和原来一样。
     *
     * @param s 字符串
     * @return 结果
     * @since v1
     * @date 2020-6-9 20:18:59
     */
    public String longestPalindrome(String s) {
        // 单个字符
        if(s.length() <= 1) {
            return s;
        }

        // 从 [i, j] 遍历处理
        // i 从左到右
        // j 从右到左
        // [0, length]
        // [1, length]/ [2, length]

        // sum 最长开始统计
        for(int sum = s.length(); sum > 1; sum--) {
            for(int i = 0; i < sum; i++) {
                int j = sum-i;

                // 如何保证第一个判断的就是最长的呢？
                if(j - i > 1) {
                    // 避免单个字符
                    String subString = s.substring(i, j);
                    System.out.println(subString);
                    String reverse = reverse(subString);
                    if(subString.equals(reverse)) {
                        return subString;
                    }
                }
            }
        }
//
//        for(int i = 0; i < s.length(); i++) {
//            for(int j = s.length(); j > i; j--) {
//                if(j - i > 1) {
//                    // 避免单个字符
//                    String subString = s.substring(i, j);
//                    String reverse = reverse(subString);
//                    if(subString.equals(reverse)) {
//                        return subString;
//                    }
//                }
//            }
//        }

        return s.substring(0, 1);
    }


    /**
     * 字符串翻转
     * @param s 字符串
     * @return 结果
     * @since v1
     */
    private String reverse(final String s) {
        return new StringBuilder(s).reverse().toString();
    }

}
