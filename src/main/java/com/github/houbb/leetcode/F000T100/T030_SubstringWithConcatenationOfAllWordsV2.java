package com.github.houbb.leetcode.F000T100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1500/30 = 50 次
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class T030_SubstringWithConcatenationOfAllWordsV2 {

    /**
     * 核心思路：
     * <p>
     * 直接遍历整个列表。
     * 依次截取（i, words.length * words[0].length）
     * <p>
     * 如何判断呢？
     * <p>
     * 答案是使用 hashMap
     * <p>
     * （1）hashMapOne 存放每一个单词，及其对应的个数
     * （2）hashMapTwo 存放截取后的字符串及对应的个数，遍历对比即可。
     * <p>
     * 【优化思路】
     *
     * 跳过一些没必要的循环。
     *
     *
     * 【效果】
     *
     * Runtime: 3 ms, faster than 99.96% of Java online submissions for Substring with Concatenation of All Words.
     * Memory Usage: 40.1 MB, less than 57.99% of Java online submissions for Substring with Concatenation of All Words.
     *
     * @param s     全部文本
     * @param words 单词列表
     * @return 整数列表
     * @since v3
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultList = new ArrayList<>();

        //fast-fail
        if (s == null || words == null || words.length == 0 || words[0].isEmpty() || words[0].length() > s.length()) {
            return resultList;
        }

        Map<String, Integer> targetMap = new HashMap<>(words.length);
        for (String word : words) {
            targetMap.put(word, targetMap.getOrDefault(word, 0) + 1);
        }

        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;

        for (int i = 0; i < wordLength; ++i) {
            int start = i;
            while (start + totalLength <= s.length()) {
                String sub = s.substring(start, start + totalLength);
                Map<String, Integer> temp = new HashMap<>();
                int c = words.length;
                while (c > 0) {
                    String word = sub.substring(wordLength * (c - 1), wordLength * c);
                    int tempC = temp.getOrDefault(word, 0) + 1;
                    if (tempC > targetMap.getOrDefault(word, 0)) {
                        break;
                    }
                    temp.put(word, tempC);
                    --c;
                }
                if (c == 0) {
                    resultList.add(start);
                }

                // 这里的跳跃应该是比较巧妙的地方
                // 如果有了一个不存在于原列表的字符串，那么就跳过它。
                start += wordLength * Math.max(c, 1);
            }
        }

        return resultList;
    }


    public static void main(String[] args) {
        T030_SubstringWithConcatenationOfAllWordsV2 allWords = new T030_SubstringWithConcatenationOfAllWordsV2();

        List<Integer> integers = allWords.findSubstring("barfoothefoobarman",
                new String[]{"foo", "bar"});

        System.out.println(integers);
    }

}
