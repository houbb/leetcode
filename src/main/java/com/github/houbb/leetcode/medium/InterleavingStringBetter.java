package com.github.houbb.leetcode.medium;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class InterleavingStringBetter {

    /**
     * 滚动数组优化
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m  = s1.length();
        int n  = s2.length();
        if(m+n != s3.length()) {
            return false;
        }

        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 0; i  <= m; i++) {
            for(int j = 0; j <= n; j++) {
                int p = i+j-1;

                if(i > 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if(j > 0) {
                    dp[j] = dp[j] || (dp[j-1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        // 获取结果
        return dp[n];
    }

    public static void main(String[] args) {
        InterleavingStringBetter interleavingString = new InterleavingStringBetter();
        // s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        // s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(interleavingString.isInterleave("", "", ""));
    }


}
