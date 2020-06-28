package com.github.houbb.leetcode;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class ImplementStrStr {

    /**
     * 【效果】
     * Runtime: 1 ms, faster than 64.82% of Java online submissions for Implement strStr().
     * Memory Usage: 38.3 MB, less than 45.26% of Java online submissions for Implement strStr().
     *
     * 最快的实现：
     *
     * string.indexOf();
     * @param haystack 原始
     * @param needle 目标
     * @return 结果
     * @since v1
     */
    public int strStr(String haystack, String needle) {
        if("".equals(needle)) {
            return 0;
        }

        char[] fullChars = haystack.toCharArray();
        char[] targetChars = needle.toCharArray();

        char first = targetChars[0];
        int max = fullChars.length - targetChars.length;

        for(int i = 0; i <= max; i++) {
            // 找到第一个元素
            if(fullChars[i] != first) {
                while (i < fullChars.length && fullChars[i] != first) {
                    i++;
                }
            }

            // 如果没有越界
            if(i <= max) {
                // 遍历剩下的元素是否相等
                int j = i+1;
                int end = j + targetChars.length - 1;

                for (int k = 1; j < end && fullChars[j] == targetChars[k]; j++, k++) {
                    ;
                }

                // 完全匹配
                if(j == end) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ImplementStrStr strStr = new ImplementStrStr();
        System.out.println(strStr.strStr("1234566", "45"));
        System.out.println(strStr.strStr("a", "a"));
        System.out.println("1234566".indexOf("45"));
    }

}
