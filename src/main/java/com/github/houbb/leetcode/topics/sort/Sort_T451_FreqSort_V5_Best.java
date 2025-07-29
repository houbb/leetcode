package com.github.houbb.leetcode.topics.sort;

public class Sort_T451_FreqSort_V5_Best {


    public String frequencySort(String s) {
        if (s.length() <= 1) {
            return s;
        }

        // 数字是字母和数字，可以用技术来直接统计
        int[] counts = new int[128];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            counts[c]++;
        }

        // 结果 模拟实现 stringBuilder
        int index = 0;
        char[] results = new char[s.length()];

        // 直接拼接
        while (index < s.length()) {
            // 找到最大的 c + 次数
            char c = 0;
            int n = 0;
            for (int i = 0; i < 128; i++) {
                if (counts[i] > n) {
                    n = counts[i];
                    c = (char) i;
                }
            }

            // 循环构建结果
            while (counts[c]-- > 0) {
                results[index++] = c;
            }
        }

        return String.valueOf(results);
    }

}
