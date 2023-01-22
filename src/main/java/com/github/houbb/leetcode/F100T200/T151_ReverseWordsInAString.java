package com.github.houbb.leetcode.F100T200;

public class T151_ReverseWordsInAString {

    public static void main(String[] args) {
        T151_ReverseWordsInAString reverseWordsInAString = new T151_ReverseWordsInAString();

        System.out.println(reverseWordsInAString.reverseWords("  hello world  "));
    }

    /**
     * 简单思路：直接根据 " " 拆分，然后过滤，拼接。
     * @param s 字符串
     * @return 结果
     */
    public String reverseWords(String s) {
        String[] strings = s.split(" ");

        // 逆序拼接
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = strings.length-1; i > 0; i--) {
            String token = strings[i].trim();
            if("".equals(token)) {
                continue;
            }

            stringBuilder.append(token).append(" ");
        }

        String first = strings[0].trim();
        if(!"".equals(first)) {
            stringBuilder.append(first);
        } else {
            // 删除最后一个空格
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }


        return stringBuilder.toString();
    }

}
