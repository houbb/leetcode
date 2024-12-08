package com.github.houbb.leetcode.topics.editdistance;

public class T72_minDistance_V1_BF {

    public int minDistance(String word1, String word2) {
        return helper(word1, word2, word1.length(), word2.length());
    }

    // 递归函数，计算word1[0..i]到word2[0..j]的最小编辑距离
    private int helper(String word1, String word2, int i, int j) {
        // 如果 word1 为空，则需要插入所有 word2 的字符
        if (i == 0) return j;

        // 如果 word2 为空，则需要删除所有 word1 的字符
        if (j == 0) return i;

        // 如果字符相等，则不需要任何操作，直接比较剩下的子串
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return helper(word1, word2, i - 1, j - 1);
        }

        // 如果字符不相等，则考虑三种操作
        int insert = helper(word1, word2, i, j - 1);  // 插入
        int delete = helper(word1, word2, i - 1, j);  // 删除
        int replace = helper(word1, word2, i - 1, j - 1);  // 替换

        // 返回三种操作中的最小值 + 1（表示进行了一次操作）
        return 1 + Math.min(Math.min(insert, delete), replace);
    }


}
