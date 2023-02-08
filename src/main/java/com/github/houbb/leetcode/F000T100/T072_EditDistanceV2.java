package com.github.houbb.leetcode.F000T100;

public class T072_EditDistanceV2 {

    /**
     * 引入 mem[][] 提升性能
     *
     * @param word1 原始单词
     * @param word2 目标单词
     */
    public int minDistance(String word1, String word2) {
        int[][] mem = new int[word1.length()+1][word2.length()+1];
        return match(word1, word2, 0, 0, mem);
    }

    /**
     * 是否匹配
     * @param s1 字符串1
     * @param s2 字符串2
     * @param i s1 指针
     * @param j s2 指针
     * @param mem 缓存
     * @return 结果
     */
    private int match(String s1, String s2, int i, int j,
                      int[][] mem) {
        // 命中缓存
        if(mem[i][j] > 0) {
            return mem[i][j];
        }


        int res;
        //如果其中一个字符串到达终点
        if(s1.length() == i) {
            res = s2.length() - j;
        } else if(s2.length() == j) {
            res = s1.length() - i;
        } else {
            // 匹配
            if(s1.charAt(i) == s2.charAt(j)) {
                res = match(s1, s2, i+1, j+1, mem);
            } else {
                // 3 种转换种最小的
                int insert = match(s1, s2, i, j+1, mem);

                int delete = match(s1, s2, i+1, j, mem);

                int replace = match(s1, s2, i+1, j+1, mem);

                // 选择三种操作中最小的一个
                res = min(insert, delete, replace) + 1;
            }
        }

        // 缓存数据
        mem[i][j] = res;
        return res;
    }

    /**
     * 返回最小的数字
     * @param nums 数字
     * @return 结果
     */
    private static int min(int ... nums) {
        int min = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(min > nums[i]) {
                min = nums[i];
            }
        }
        return min;
    }

}
