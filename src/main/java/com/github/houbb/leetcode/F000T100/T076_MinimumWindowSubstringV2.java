package com.github.houbb.leetcode.F000T100;

import java.util.HashMap;
import java.util.Map;

public class T076_MinimumWindowSubstringV2 {

    public static void main(String[] args) {
        T076_MinimumWindowSubstringV2 minimumWindowSubstring = new T076_MinimumWindowSubstringV2();

        System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minimumWindowSubstring.minWindow("a", "a"));
        System.out.println(minimumWindowSubstring.minWindow("a", "aa"));
    }

    /**
     * 通过 step 的方式判断
     * <p>
     * 265 / 267 TEL 超时
     *
     * @param s 原始
     * @param t 目标
     * @return 结果
     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // 构建 t 的 hashMap，而不是每次都去构建
        Map<Character, Integer> targetMap = new HashMap<>();
        // 如果匹配
        for (char c : t.toCharArray()) {
            Integer count = targetMap.get(c);
            if (count == null) {
                count = 0;
            }

            count++;
            targetMap.put(c, count);
        }

        // 从头开始遍历
        // 这里调整一下，为了复用 sourceMap

        Map<Character, Integer> sourceMap = new HashMap<>();

        // 固定步长考虑，这样步长最小的时候，可以优先获取答案。
        for (int stepLen = t.length(); stepLen <= s.length(); stepLen++) {

            // 清空
            sourceMap = new HashMap<>();

            // 遍历字符串
            // 从 stepLen-1 开始
            for (int i = stepLen-1; i < s.length(); i++) {
                // 如何复用上一次的结果呢？
                //[0.3] [1,4] 其实只有第一个位置发生了变化

                //如果是开始，把 [0, stepLen] 的元素都放进来。
                if (i == (stepLen-1)) {
                    for (int k = 0; k < stepLen; k++) {
                        Character sc = s.charAt(k);
                        Integer count = sourceMap.getOrDefault(sc, 0);
                        sourceMap.put(sc, count + 1);
                    }

                    if (isValid(sourceMap, targetMap)) {
                        // 截取开头
                        return s.substring(0, stepLen);
                    }
                } else {
                    // 如果不是，则需要移除 i-1 的元素，加入 i + len 的元素。更新 map
                    Character lastChar = s.charAt(i - stepLen);
                    Integer lastCount = sourceMap.getOrDefault(lastChar, 0);
                    sourceMap.put(lastChar, lastCount - 1);

                    // 加入新的
                    Character newChar = s.charAt(i);
                    Integer newCount = sourceMap.getOrDefault(newChar, 0);
                    sourceMap.put(newChar, newCount + 1);

                    if (isValid(sourceMap, targetMap)) {
                        return s.substring(i+1-stepLen, i+1);
                    }
                }
            }
        }

        return "";
    }

    /**
     * 匹配完之后
     *
     * @param sourceMap 原始
     * @param targetMap t 对应的 map
     * @return
     */
    private boolean isValid(Map<Character, Integer> sourceMap, Map<Character, Integer> targetMap) {
        // 如果匹配
        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            Character character = entry.getKey();
            Integer count = entry.getValue();

            // 不够
            Integer sourceCount = sourceMap.get(character);
            if (sourceCount == null || sourceCount < count) {
                return false;
            }
        }

        return true;
    }

}
