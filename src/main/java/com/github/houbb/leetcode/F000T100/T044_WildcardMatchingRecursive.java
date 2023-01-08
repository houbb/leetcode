package com.github.houbb.leetcode.F000T100;

/**
 * @author d
 * @since 1.0.0
 */
public class T044_WildcardMatchingRecursive {

    /**
     * 递归
     * @param str
     * @param pattern
     * @return
     */
    boolean isMatch(String str, String pattern) {
        return recursive(str.toCharArray(), pattern.toCharArray(), 0, 0);
    }

    private boolean recursive(char[] s, char[] p,
                              int i,
                              int j) {

        //p 结束，判断 s 是否结束
        if (j == p.length) {
            return i == s.length;
        }

        // s 结束，判断 p 当前是否为 *，且前面的都匹配
        if (i == s.length) {
            return (p[j] == '*' && recursive(s, p, i, j + 1));
        }

        if (p[j] == '*') {
            // p 为 * 的处理
            return recursive(s, p, i + 1, j) || recursive(s, p, i, j + 1);
        } else {
            // 其他 case, 二者相同。或者 p 为 ?
            if(i < s.length && (p[j] == s[i] || p[j] == '?')) {
                return recursive(s, p, i + 1, j + 1);
            }

            // 不匹配
            return false;
        }
    }

}
