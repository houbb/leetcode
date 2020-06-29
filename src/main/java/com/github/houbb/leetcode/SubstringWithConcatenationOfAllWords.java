package com.github.houbb.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1500/30 = 50 次
 * @author binbin.hou
 * @since 1.0.0
 */
public class SubstringWithConcatenationOfAllWords {

    /**
     * 核心思路：
     *
     * 直接遍历整个列表。
     * 依次截取（i, words.length * words[0].length）
     *
     * 如何判断呢？
     *
     * 答案是使用 hashMap
     *
     * （1）hashMapOne 存放每一个单词，及其对应的个数
     * （2）hashMapTwo 存放截取后的字符串及对应的个数，遍历对比即可。
     *
     * 【效果】
     * Runtime: 211 ms, faster than 32.43% of Java online submissions for Substring with Concatenation of All Words.
     * Memory Usage: 40 MB, less than 64.21% of Java online submissions for Substring with Concatenation of All Words.
     *
     * @param s 全部文本
     * @param words 单词列表
     * @return 整数列表
     * @since v1
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultList = new ArrayList<>();

        //fast-fail
        if(words.length == 0) {
            return resultList;
        }

        Map<String, Integer> targetMap = buildTargetMap(words);

        int wordLength = words[0].length();
        int totalLength = words.length * wordLength;
        for(int i = 0; i <= s.length() - totalLength; i++) {
            String subText = s.substring(i, totalLength+i);

            Map<String, Integer> subMap = buildSubMap(subText, wordLength);
            if(isMatch(targetMap, subMap)) {
                resultList.add(i);
            }
        }

        return resultList;
    }

    private boolean isMatch(final Map<String, Integer> targetMap,
                            final Map<String, Integer> subMap) {

        for(Map.Entry<String, Integer> entry : targetMap.entrySet()) {
            String word = entry.getKey();
            Integer targetCounter = entry.getValue();
            Integer subCounter = subMap.get(word);

            // 判断是否匹配
            if(!targetCounter.equals(subCounter)) {
                return false;
            }
        }

        return true;
    }

    private Map<String, Integer> buildSubMap(String subText, int wordLength) {
        int size = subText.length() / wordLength;

        Map<String, Integer> map = new HashMap<>(size);
        for(int i = 0; i < subText.length(); i += wordLength) {
            String word = subText.substring(i, i+wordLength);
            Integer counter = map.get(word);
            if(counter == null) {
                counter = 0;
            }
            counter++;
            map.put(word, counter);
        }

        return map;
    }

    private Map<String, Integer> buildTargetMap(String[] words) {
        Map<String, Integer> map = new HashMap<>(words.length);
        for(String word : words) {
            Integer counter = map.get(word);
            if(counter == null) {
                counter = 0;
            }
            counter++;
            map.put(word, counter);
        }
        return map;
    }


    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords allWords = new SubstringWithConcatenationOfAllWords();

        List<Integer> integers = allWords.findSubstring("barfoothefoobarman",
                new String[]{"foo", "bar"});

        System.out.println(integers);
    }

}
