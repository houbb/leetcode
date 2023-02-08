package com.github.houbb.leetcode.F200T300;

public class T214_ShortestPalindrome {


    public String shortestPalindrome(String s) {
        // 本身就是
        if(isPalindrome(s)) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        for(int i = s.length()-1; i >=0; i--) {
            builder.append(s.charAt(i));
            String newStr = builder + s;

            if(isPalindrome(newStr)) {
                return newStr;
            }
        }

        return "";
    }



    /**
     * 是否为回文
     *
     * @param string 字符串
     * @return 是否
     */
    public static boolean isPalindrome(final String string) {
        if (string.length() == 1) {
            return false;
        }
        final int length = string.length();
        int mid = length >> 1;
        for (int i = 0; i < mid; i++) {
            if (string.charAt(i) != string.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
