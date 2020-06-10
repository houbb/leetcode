package com.github.houbb.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p> project: leetcode-RegularExpressionMatching </p>
 * <p> create on 2020/6/10 20:21 </p>
 *
 * @author binbin.hou
 * @since v1
 */
public class RegularExpressionMatching {

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
    public boolean isMatch(String s, String p) {
        //fast-fail
        if(s.isEmpty() || p.isEmpty()) {
            return false;
        }

        // 偷懒的方式，直接使用 java 的正则表达式
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

}
