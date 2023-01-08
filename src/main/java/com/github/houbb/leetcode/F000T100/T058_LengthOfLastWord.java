package com.github.houbb.leetcode.F000T100;

/**
 * @author d
 * @since 1.0.0
 */
public class T058_LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(new T058_LengthOfLastWord().lengthOfLastWord("a"));
    }

    /**
     * 找到字符串中最后一个单词的长度
     *
     * 1. 从后往前遍历
     * 2. 第一个不是空的字符开始计算，然后遇到第一个空字符串 || 开始结束
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int startIndex = -1;
        for(int i = s.length()-1; i >=0; i--) {
            // 第一个费控字符开始计算
            if(s.charAt(i) != ' '
                && startIndex == -1) {
                startIndex = i;
            }

            // 开始已经有了
            // 遇到了空格终止，或者已经结束
            if(startIndex != -1) {
                // 空格终止的
                if(s.charAt(i) == ' ') {
                    return startIndex - i;
                }
                //a
                if(i == 0) {
                   return startIndex + 1;
                }
            }
        }

        return 0;
    }

}
