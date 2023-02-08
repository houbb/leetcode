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
public class T030_SubstringWithConcatenationOfAllWordsSlideWindow {

    /**
     * 核心思路：
     * <p>
     * 原来是每次移动一个位置，这里调整为每次移动整个单词组的长度。
     * <p>
     * 比如 ["hello", "world"]
     * <p>
     * 我们移动位置如下：
     * 0 10 20
     * 1 11 21
     * 2 12 22
     * ......
     * 9 19 29
     * <p>
     * 如此避免遗漏，后续将提供优化的版本
     * <p>
     * 【效果】
     * Runtime: 205 ms, faster than 33.12% of Java online submissions for Substring with Concatenation of All Words.
     * Memory Usage: 40.1 MB, less than 62.91% of Java online submissions for Substring with Concatenation of All Words.
     *
     * @param s     全部文本
     * @param words 单词列表
     * @return 整数列表
     * @since v2
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultList = new ArrayList<>();

        //fast-fail
        if (words.length == 0) {
            return resultList;
        }

        Map<String, Integer> targetMap = buildTargetMap(words);

        int wordLength = words[0].length();
        int totalLength = words.length * wordLength;
        for (int i = 0; i < wordLength; i++) {
            for (int j = i; j <= s.length() - totalLength; j += wordLength) {
                String subText = s.substring(j, totalLength + j);
                Map<String, Integer> subMap = buildSubMap(subText, wordLength);
                if (isMatch(targetMap, subMap)) {
                    resultList.add(j);
                }
            }
        }

        return resultList;
    }

    private boolean isMatch(final Map<String, Integer> targetMap,
                            final Map<String, Integer> subMap) {
        for (Map.Entry<String, Integer> entry : targetMap.entrySet()) {
            String word = entry.getKey();
            Integer targetCounter = entry.getValue();
            Integer subCounter = subMap.get(word);

            // 判断是否匹配
            if (!targetCounter.equals(subCounter)) {
                return false;
            }
        }

        return true;
    }

    private Map<String, Integer> buildSubMap(String subText, int wordLength) {
        int size = subText.length() / wordLength;
        Map<String, Integer> map = new HashMap<>(size);
        for (int i = 0; i < subText.length(); i += wordLength) {
            String word = subText.substring(i, i + wordLength);
            Integer counter = map.getOrDefault(word, 0) + 1;
            map.put(word, counter);
        }

        return map;
    }

    private Map<String, Integer> buildTargetMap(String[] words) {
        Map<String, Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            Integer counter = map.getOrDefault(word, 0) + 1;
            map.put(word, counter);
        }
        return map;
    }

    public static void main(String[] args) {
        T030_SubstringWithConcatenationOfAllWordsSlideWindow allWords = new T030_SubstringWithConcatenationOfAllWordsSlideWindow();

        List<Integer> integers = allWords.findSubstring("barfoothefoobarman",
                new String[]{"foo", "bar"});
        System.out.println(integers);

        List<Integer> integers2 = allWords.findSubstring("ababaab",
                new String[]{"ab", "ba", "ba"});
        System.out.println(integers2);
    }

}
