package com.github.houbb.leetcode.F100T200;

public class T151_ReverseWordsInAStringV2 {

    public static void main(String[] args) {
        T151_ReverseWordsInAStringV2 reverseWordsInAString = new T151_ReverseWordsInAStringV2();

        System.out.println(reverseWordsInAString.reverseWords("  hello world  "));
    }

    /**
     * 简单思路：直接根据 " " 拆分，然后过滤，拼接。
     *
     * 优化思路：直接从后往前遍历，O(n) 一次遍历分词+过滤
     * @param s 字符串
     * @return 结果
     */
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);

            // 如果是空格，则终止
            if(' ' == c) {
                // 判断 temp 是否已有数据
                if(temp.length() > 0) {
                    stringBuilder.append(temp.reverse())
                            .append(" ");

                    // 清空
                    temp = new StringBuilder();
                }
            } else {
                temp.append(c);
            }
        }

        // 最后加入
        if(temp.length() > 0) {
            stringBuilder.append(temp.reverse());
        } else {
            // 删除最后一个空格
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }


        return stringBuilder.toString();
    }

}
