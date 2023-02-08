package com.github.houbb.leetcode.F000T100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class T030_SubstringWithConcatenationOfAllWordsSlideWindowOptimize {

    /**
     * 核心思路：
     *
     * 原来是每次移动一个位置，这里调整为每次移动整个单词组的长度。
     *
     * 比如 ["hello", "world"]
     *
     * 我们移动位置如下：
     * 0 10 20
     * 1 11 21
     * 2 12 22
     * ......
     * 9 19 29
     *
     * 如此避免遗漏，后续将提供优化的版本
     *
     * 【优化思路】
     *
     *
     * 【效果】
     *
     * Runtime: 5 ms, faster than 96.75% of Java online submissions for Substring with Concatenation of All Words.
     * Memory Usage: 40 MB, less than 64.75% of Java online submissions for Substring with Concatenation of All Words.
     *
     * @param s 全部文本
     * @param words 单词列表
     * @return 整数列表
     * @since v2
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        int wordLen = words[0].length();
        HashMap<String, Integer> allWords = new HashMap<>();
        for (String w : words) {
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }

        //将所有移动分成 wordLen 类情况
        for (int j = 0; j < wordLen; j++) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            //记录当前 HashMap2（这里的 hasWords 变量）中有多少个单词
            int num = 0;
            //每次移动一个单词长度
            for (int i = j; i < s.length() - wordNum * wordLen + 1; i = i + wordLen) {
                boolean hasRemoved = false; //防止情况三移除后，情况一继续移除
                while (num < wordNum) {
                    String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                    if (allWords.containsKey(word)) {
                        int value = hashMap.getOrDefault(word, 0);
                        hashMap.put(word, value + 1);
                        //出现情况三，遇到了符合的单词，但是次数超了
                        if (hashMap.get(word) > allWords.get(word)) {
                            hasRemoved = true;
                            int removeNum = 0;
                            //一直移除单词，直到次数符合了
                            while (hashMap.get(word) > allWords.get(word)) {
                                String firstWord = s.substring(i + removeNum * wordLen, i + (removeNum + 1) * wordLen);
                                int v = hashMap.get(firstWord);
                                hashMap.put(firstWord, v - 1);
                                removeNum++;
                            }
                            num = num - removeNum + 1; //加 1 是因为我们把当前单词加入到了 HashMap 2 中
                            i = i + (removeNum - 1) * wordLen; //这里依旧是考虑到了最外层的 for 循环，看情况二的解释
                            break;
                        }
                        //出现情况二，遇到了不匹配的单词，直接将 i 移动到该单词的后边（但其实这里
                        //只是移动到了出现问题单词的地方，因为最外层有 for 循环， i 还会移动一个单词
                        //然后刚好就移动到了单词后边）
                    } else {
                        hashMap.clear();
                        i = i + num * wordLen;
                        num = 0;
                        break;
                    }
                    num++;
                }
                if (num == wordNum) {
                    res.add(i);

                }
                //出现情况一，子串完全匹配，我们将上一个子串的第一个单词从 HashMap2 中移除
                if (num > 0 && !hasRemoved) {
                    String firstWord = s.substring(i, i + wordLen);
                    int v = hashMap.get(firstWord);
                    hashMap.put(firstWord, v - 1);
                    num = num - 1;
                }

            }

        }
        return res;
    }

    public static void main(String[] args) {
        T030_SubstringWithConcatenationOfAllWordsSlideWindowOptimize allWords = new T030_SubstringWithConcatenationOfAllWordsSlideWindowOptimize();

        List<Integer> integers = allWords.findSubstring("barfoothefoobarman",
                new String[]{"foo", "bar"});
        System.out.println(integers);

        List<Integer> integers2 = allWords.findSubstring("ababaab",
                new String[]{"ab", "ba", "ba"});
        System.out.println(integers2);
    }

}
