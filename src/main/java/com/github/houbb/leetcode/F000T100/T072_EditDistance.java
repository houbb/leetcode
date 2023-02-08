package com.github.houbb.leetcode.F000T100;

public class T072_EditDistance {

    /**
     * 这是一个回溯题目吗？
     *
     * 还是说其实根本不需要？
     *
     * 直接根据一个位置的变化，来处理。其实增加/删除是可以忽略的。
     *
     * （1）如果位数不同，那么我们直接通过 add/del 加一个位数，且为了保证最少，直接变化需要的即可。
     *
     * 如果保证变化的，刚好就是需要的呢？
     *
     * （2）如果位数上对应的字母不同，那么直接一次替换即可。
     *
     * 直接一次 O(n) 的遍历，统计出不同的字母即可。
     *
     * https://web.stanford.edu/class/cs124/lec/med.pdf
     *
     * @param word1 原始单词
     * @param word2 目标单词
     */
    public int minDistance(String word1, String word2) {
        if(isEmpty(word1)) {
            return word2.length();
        }
        if(isEmpty(word2)) {
            return word1.length();
        }

        return match(word1, word2, 0, 0);
    }

    /**
     * 是否匹配
     * @param s1 字符串1
     * @param s2 字符串2
     * @param i s1 指针
     * @param j s2 指针
     * @return 结果
     */
    private int match(String s1, String s2, int i, int j) {
        //如果其中一个字符串到达终点
        if(s1.length() == i) {
            return s2.length() - j;
        }
        if(s2.length() == j) {
            return s1.length() - i;
        }

        // 匹配
        int res;
        if(s1.charAt(i) == s2.charAt(j)) {
            res = match(s1, s2, i+1, j+1);
        } else {
            // 3 种转换种最小的
            int insert = match(s1, s2, i, j+1);

            int delete = match(s1, s2, i+1, j);

            int replace = match(s1, s2, i+1, j+1);

            // 选择三种操作中最小的一个
            res = min(insert, delete, replace) + 1;
        }

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

    private static boolean isEmpty(String word) {
        return word == null || word.length() <= 0;
    }

}
