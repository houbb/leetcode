package com.github.houbb.leetcode.F000T100;

public class T087_ScrambleStringV3 {

    public static void main(String[] args) {
        T087_ScrambleStringV3 scrambleString = new T087_ScrambleStringV3();

        scrambleString.isScramble("abcde", "caebd");
    }

    /**
     * 递归
     *
     * 添加缓存
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        // 初始化 dp 数组
        int totalLen = s1.length();
        boolean[][][] dp = new boolean[totalLen +1][totalLen][totalLen];
        // 如果 i, j 位置的字符相同，则更新为 true。
        for(int i = 0; i < totalLen; i++) {
            for(int j = 0; j < totalLen; j++) {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }


        // k 这一层，类似于之前的最外层
        for (int len = 2; len <= totalLen; len++) {
            for (int i = 0; i <= totalLen - len; i++) {
                for (int j = 0; j <= totalLen - len; j++) {
                    //???
                    dp[len][i][j] = false;

                    for (int k = 1; k < len && !dp[len][i][j]; k++) {
                        dp[len][i][j] = dp[len][i][j] || (dp[k][i][j] && dp[len-k][i+k][j+k]);
                        dp[len][i][j] = dp[len][i][j] || (dp[k][i+len-k][j] && dp[len-k][i][j+k]);
                    }
                }
            }
        }

        // 返回结果
        return dp[totalLen][0][0];
    }

}
