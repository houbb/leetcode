package com.github.houbb.leetcode.F100T200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T132_PalindromePartitioningV2 {

    /**
     * DP思想：
     *
     *
     * 1. 关于回文的判断，可以使用 dp
     * 2. 关于最小次数，也可以使用 dp 递归。
     *
     * 这是一道 dp 应用比较巧妙的一道题。
     *
     * @param s 字符串
     * @return 结果
     */
    public int minCut(String s) {
        // 最小砍几刀
        int[] minCuts = new int[s.length()];

        // 初始化 dp 数组
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 初始化
        for(int i = 0; i < s.length(); i++) {
            // 最多就是和 i 一样，每个元素都拆分开。
            int min = i;

            // 回文判断
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;

                    // 如果 j 是 0，此时不需要切分。初始化的默认值
                    if(j == 0) {
                        min = 0;
                    } else {
                        // 最多切法，或者上一次最小的+1
                        min = Math.min(min, minCuts[j-1] + 1);
                    }
                }
            }

            // 更新
            minCuts[i] = min;
        }

        // 最后的值就是结果
        return minCuts[s.length()-1];
    }


}
