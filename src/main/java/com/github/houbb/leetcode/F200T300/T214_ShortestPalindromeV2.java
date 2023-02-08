package com.github.houbb.leetcode.F200T300;

public class T214_ShortestPalindromeV2 {


    public static void main(String[] args) {
        T214_ShortestPalindromeV2 v2 = new T214_ShortestPalindromeV2();

        System.out.println(v2.shortestPalindrome("aacecaaa").equals("aaacecaaa"));

        System.out.println(v2.shortestPalindrome("abcd").equals("dcbabcd"));
    }

    public String shortestPalindrome(String s) {
        // 本身就是
        if(isPalindrome(s)) {
            return s;
        }

        // 从头开始，寻找最长的回文子串。
        StringBuilder stringBuilder = new StringBuilder(s);
        //从末尾开始，逐步删除1位
        for(int i = s.length()-1; i >= 0; i--) {
            stringBuilder.deleteCharAt(i);

            // 判断是否为回文
            if(isPalindrome(stringBuilder.toString())) {
                break;
            }
        }

        // 如果 abcd 都不是回文，那么其实是从 1 开始，因为第一个可以当中间。 bcd => dc b cd
        // 减去剩下的，翻转加到开始
        int len = Math.max(1, stringBuilder.length());
        String remainStr = s.substring(len);
        return new StringBuilder(remainStr).reverse() + s;
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
