package com.github.houbb.leetcode.F200T300;

public class T214_ShortestPalindromeV3 {


    public static void main(String[] args) {
        T214_ShortestPalindromeV3 v2 = new T214_ShortestPalindromeV3();

        System.out.println(v2.shortestPalindrome("aacecaaa").equals("aaacecaaa"));

        System.out.println(v2.shortestPalindrome("abcd").equals("dcbabcd"));
    }

    /**
     * 哈希算法
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        int base = 131, mod = 1000000007;
        int left = 0, right = 0, mul = 1;
        int best = -1;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            // 正序哈希
            left = (int) (((long) left * base + c) % mod);
            // 反序哈希
            right = (int) ((right + (long) mul * c) % mod);

            // 相同则为同一个
            if (left == right) {
                best = i;
            }

            mul = (int) ((long) mul * base % mod);
        }

        String add = (best == s.length() - 1 ? "" : s.substring(best + 1));
        StringBuilder ans = new StringBuilder(add)
                .reverse()
                .append(s);

        return ans.toString();
    }

}
