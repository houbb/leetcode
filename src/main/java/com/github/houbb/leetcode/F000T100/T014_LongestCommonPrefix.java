package com.github.houbb.leetcode.F000T100;

/**
 * 无公共的返回 ""
 *
 * 所有的字母都是 a-z 的小写。
 * <p> project: leetcode-LongestCommonPrefix </p>
 * <p> create on 2020/6/11 22:18 </p>
 *
 * @author binbin.hou
 * @since v1
 * @date 2020-6-11 22:18:48
 */
public class T014_LongestCommonPrefix {

    /**
     * 双 100%
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(null == strs || strs.length <= 0) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        // 遍历每一个字符串
        // 第一个字符串的长度即可

        for(int i = 0; i < strs[0].length(); i++) {
            char sameChar = getAllSameChar(i, strs);

            if(sameChar != '\0') {
                stringBuilder.append(sameChar);
            } else {
                break;
            }
        }

        return stringBuilder.toString();
    }

    private char getAllSameChar(final int index, String[] strings) {
        char c = '\0';
        for(int i = 0; i < strings.length; i++) {
            String string = strings[i];

            if(index >= string.length()) {
                return '\0';
            }
            if(i == 0) {
                c = string.charAt(index);
            } else {
                // 值不等
                if(string.charAt(index) != c) {
                    return '\0';
                }
            }
        }

        return c;
    }

}
