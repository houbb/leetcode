package com.github.houbb.leetcode.medium;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int m  = s1.length();
        int n  = s2.length();
        if(m+n != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for(int i = 0; i  <= m; i++) {
            for(int j = 0; j <= n; j++) {
                int p = i+j-1;

                if(i > 0) {
                    //官方代码前面这个'f[i][j] ||'是没必要的
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if(j > 0) {
                    //如果前一步i>0时已算出f[i][j]为true，则下面的||会短路，f[i][j]直接就是true了
                    dp[i][j] = dp[i][j] || (dp[i][j-1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        // 获取结果
        return dp[m][n];
    }

    public static void main(String[] args) {
        InterleavingString interleavingString = new InterleavingString();
        // s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        // s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(interleavingString.isInterleave("", "", ""));
    }


}
