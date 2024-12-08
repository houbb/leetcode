package com.github.houbb.leetcode.topics.editdistance;

import java.util.ArrayList;
import java.util.List;

public class T72_minDistanceList_V1_DP {

    public static void main(String[] args) {
        T72_minDistanceList_V1_DP dp = new T72_minDistanceList_V1_DP();
        System.out.println(dp.minDistance("horse", "ros"));
    }


    public List<String> minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // DP数组，记录最小操作数
        int[][] dp = new int[m + 1][n + 1];
        // 操作类型数组，记录操作类型："" = no-op, "insert", "delete", "replace"
        String[][] operation = new String[m + 1][n + 1];

        // 初始化
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
            operation[i][0] = "delete";
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
            operation[0][j] = "insert";
        }

        // 填充DP表和操作类型表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    operation[i][j] = ""; // 字符相等，不需要操作
                } else {
                    int insert = dp[i][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int replace = dp[i - 1][j - 1] + 1;

                    // 选择最小的操作
                    dp[i][j] = Math.min(Math.min(insert, delete), replace);

                    // 记录操作类型
                    if (dp[i][j] == insert) {
                        operation[i][j] = "insert";
                    } else if (dp[i][j] == delete) {
                        operation[i][j] = "delete";
                    } else {
                        operation[i][j] = "replace";
                    }
                }
            }
        }

        // 回溯操作路径，生成变换过程
        List<String> result = new ArrayList<>();
        int i = m, j = n;
        StringBuilder currentWord = new StringBuilder(word1);

        // 回溯路径
        while (i > 0 || j > 0) {
            addNewWord(result, currentWord.toString());
            if (operation[i][j].equals("")) {
                i--;
                j--;
            } else if (operation[i][j].equals("insert")) {
                currentWord.insert(i, word2.charAt(j - 1));
                j--;
            } else if (operation[i][j].equals("delete")) {
                currentWord.deleteCharAt(i - 1);
                i--;
            } else if (operation[i][j].equals("replace")) {
                currentWord.setCharAt(i - 1, word2.charAt(j - 1));
                i--;
                j--;
            }
        }

        // 添加初始单词到变换过程
        addNewWord(result, currentWord.toString());

        // 由于回溯是从后往前的，因此需要反转结果
//        Collections.reverse(result);
        return result;
    }

    // 避免数据重复
    private void addNewWord(List<String> list, String word) {
        if(list.size() > 0 && word.equals(list.get(list.size()-1))) {
            return;
        }

        list.add(word);
    }


}
