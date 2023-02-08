package com.github.houbb.leetcode.F200T300;

public class T214_ShortestPalindromeV4 {


    public static void main(String[] args) {
        T214_ShortestPalindromeV4 v2 = new T214_ShortestPalindromeV4();

        System.out.println(v2.shortestPalindrome("aacecaaa").equals("aaacecaaa"));

        System.out.println(v2.shortestPalindrome("abcd").equals("dcbabcd"));
    }

    /**
     * KMP
     *
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }

        // 翻转相加
        String rev = new StringBuffer(s).reverse().toString();
        rev = s + "#" + rev;

        // 计算 kmp next 数组
        int index = kmp(rev);

        // 截取拼接
        return new StringBuffer(s.substring(index+1)).reverse() +s;
    }

    /**
     * 计算 kmp 的 next 数组，这里只需要返回最后一个值即可。
     *
     * @param pattern
     * @return
     */
    private int kmp(String pattern) {
        int n = pattern.length();
        int[] next = new int[n];
        next[0]=-1;

        int j = -1;
        for(int i=1; i<n; i++){
            while(j != -1 && pattern.charAt(i)!= pattern.charAt(j+1)) {
                j=next[j];
            }
            if(pattern.charAt(i)== pattern.charAt(j+1)) {
                j+=1;
            }
            next[i]=j;
        }

        return next[n-1];
    }

}
