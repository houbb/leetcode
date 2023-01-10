package com.github.houbb.leetcode.F000T100;

import java.util.HashMap;
import java.util.Map;

public class T076_MinimumWindowSubstring {

    public static void main(String[] args) {
        T076_MinimumWindowSubstring minimumWindowSubstring = new T076_MinimumWindowSubstring();

        System.out.println(minimumWindowSubstring.minWindow("bbaa", "aba"));
    }

    /**
     * 通过 step 的方式判断
     *
     * 264 / 267 TEL 超时
     *
     * @param s 原始
     * @param t 目标
     * @return 结果
     */
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }


        // 从头开始遍历
        for(int stepLen = t.length(); stepLen <= s.length(); stepLen++) {
            for(int i = 0; i <= s.length() - stepLen; i++) {
                // 是否匹配
                String matchString = matchString(s, i, i + stepLen, t);
                if(matchString.length() > 0) {
                    return matchString;
                }
            }
        }

        return "";
    }

    /**
     * 匹配完之后，要剔除掉。
     * @param sourceString
     * @param target
     * @return
     */
    private String matchString(String sourceString,
                               int startIndex,
                               int endIndex,
                               String target) {
        StringBuilder stringBuilder = new StringBuilder();

        // 是否包含所有的字符？
        Map<Character, Integer> map = new HashMap<>();
        for(int i = startIndex; i < endIndex; i++) {
            char c = sourceString.charAt(i);
            stringBuilder.append(c);

            Integer count = map.get(c);
            if(count == null) {
                count = 0;
            }
            count++;
            map.put(c, count);
        }

        // 如果匹配
        for(char c : target.toCharArray()) {
            Integer count = map.get(c);
            if(count == null
                || count <= 0) {
                return "";
            }

            count--;
            map.put(c, count);
        }


        return stringBuilder.toString();
    }

}
