package com.github.houbb.leetcode.medium;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class InterleavingStringError {

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char[] one = s1.toCharArray();
        char[] two = s2.toCharArray();

        int oneIndex = 0;
        int twoIndex = 0;

        char[] three  =s3.toCharArray();
        for(int i = 0; i < three.length; i++) {
            char c = three[i];

            if(oneIndex < one.length && c == one[oneIndex]) {
                oneIndex++;
            } else if(twoIndex < two.length && c == two[twoIndex]) {
                twoIndex++;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        InterleavingStringError interleavingString = new InterleavingStringError();
        // s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        // s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
//        System.out.println(interleavingString.isInterleave("", "", ""));
    }


}
