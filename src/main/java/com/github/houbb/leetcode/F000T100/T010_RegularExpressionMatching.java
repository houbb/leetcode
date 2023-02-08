package com.github.houbb.leetcode.F000T100;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p> project: leetcode-RegularExpressionMatching </p>
 * <p> create on 2020/6/10 20:21 </p>
 *
 * @author binbin.hou
 * @since v1
 */
public class T010_RegularExpressionMatching {

    /**
     * 正则表达式
     *
     * 方式：递归
     * 思路：从简单到复杂。
     *
     * . 出现一次
     * * 出现0次或者多次
     *
     * 1. 最简单的常见，不存在 [.*]，则和普通的字符串匹配一样。
     * 2. 如果存在 *，那么稍微会复杂一点
     *
     * 2.1 第一个位是否匹配。firstMatch = (s[0] == p[0] || '.' == p[0]); //如果 p[0] 为 * 怎么办？
     * 2.2 考虑 * 号对应 pattern 的第二个位置
     *
     * <pre>
     *      if(p.len >= 2 && p[1] == '*') {
     *          // 第一位匹配 && 后续匹配
     *          firstMatch && isMatchDp(s.sub(1), p);
     *
     *          // * 代替出现 0 次，则忽略 pattern 前2个元素。 1*（出现0次）
     *          isMatchDp(s, p.sub(2));
     *      }
     * </pre>
     *
     *
     * 2.3 其他非 * 场景，直接递归对比后面的元素。
     *
     * <pre>
     *      firstMatch && isMatchDp(s.sub(1), p.sub(1))
     * </pre>
     *
     * 【效果】
     * Runtime: 88 ms, faster than 8.51% of Java online submissions for Regular Expression Matching.
     * Memory Usage: 39.8 MB, less than 27.13% of Java online submissions for Regular Expression Matching.
     *
     * ps: 肉眼可见的很慢。
     *
     * @param s 字符串
     * @param p 表达式
     * @return 是否匹配
     * @since v2
     */
    public boolean isMatchRecursive(String s, String p) {
        //结束条件
        if(p.isEmpty()) {
            return s.isEmpty();
        }
        // 全匹配，保证 pattern 遍历结束
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if(p.length() >= 2 && p.charAt(1) == '*') {
            return (firstMatch && isMatchRecursive(s.substring(1), p)) || isMatchRecursive(s, p.substring(2));
        } else {
            return firstMatch && isMatchRecursive(s.substring(1), p.substring(1));
        }
    }

    /**
     * 正则表达式
     *
     * Runtime: 64 ms, faster than 24.57% of Java online submissions for Regular Expression Matching.
     * Memory Usage: 40.3 MB, less than 7.95% of Java online submissions for Regular Expression Matching.
     *
     * ps: 这样就没有一点意思了，需要我们重新学习一边，自己实现。
     * @param s 字符串
     * @param p 表达式
     * @return 是否匹配
     */
    public boolean isMatchJdk(String s, String p) {
        //fast-fail
        if(s.isEmpty() || p.isEmpty()) {
            return false;
        }

        // 偷懒的方式，直接使用 java 的正则表达式
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    /**
     * happy java
     * @param s 字符串
     * @param p 模式
     * @return 是否匹配
     * @since v1
     */
    public boolean isMatchJdk2(String s, String p) {
        return s.matches(p);
    }

}
