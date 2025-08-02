package com.github.houbb.leetcode.topics.slidlingWindows;

import java.util.HashMap;
import java.util.Map;

public class T76_MinimumWindowSubstring_V1_BF {

    public static void main(String[] args) {
        T76_MinimumWindowSubstring_V1_BF v1Bf = new T76_MinimumWindowSubstring_V1_BF();
        String result = v1Bf.minWindow("bbaa", "aba");
        System.out.println(result);
    }

    /**
     * 返回 s 中涵盖 t 所有字符的最小子串。
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        //
        char[] tcs = t.toCharArray();
        char[] scs = s.toCharArray();

        int left = 0;
        int right = 0;

        // 遍历所有的可能性
        String result = null;

        // 字符统计，可以优化为数组
        Map<Character, Integer> targetCountMap = new HashMap<>();
        for(char c : tcs) {
            Integer count = targetCountMap.getOrDefault(c, 0);
            count++;
            targetCountMap.put(c, count);
        }

        for(left = 0; left < s.length(); left++) {
            for(right = left; right < s.length(); right++) {
                // 判断字符的可能性
                int len = right-left+1;

                // 长度不够，直接跳过
                if(len < t.length()) {
                    continue;
                }

                // 然后判断
                Map<Character, Integer> sourceCountMap = new HashMap<>();
                StringBuilder stringBuilder = new StringBuilder();
                for(int i = left; i <= right; i++) {
                    char c = scs[i];
                    Integer count = sourceCountMap.getOrDefault(c , 0);
                    count++;
                    sourceCountMap.put(c, count);
                    stringBuilder.append(c);
                }

                // 判断是否满足条件
                if(isMatchCondition(sourceCountMap, targetCountMap)) {
                    if(result == null) {
                        result = stringBuilder.toString();
                    } else {
                        if(result.length() > stringBuilder.length()) {
                            result = stringBuilder.toString();
                        }
                    }
                }
            }
        }


        // 默认为空
        if(result == null) {
            result = "";
        }
        return result;
    }

    private boolean isMatchCondition(Map<Character, Integer> sourceCountMap,
                                     Map<Character, Integer> targetCountMap) {
        if(sourceCountMap.size() < targetCountMap.size()) {
            return false;
        }


        // t 的每个 char，s 都有大于等于的
        for(Map.Entry<Character, Integer> entry : targetCountMap.entrySet()) {
            Character tc = entry.getKey();
            Integer tCount = entry.getValue();

            Integer sCount = sourceCountMap.get(tc);
            if(sCount == null) {
                return false;
            }
            if(sCount < tCount) {
                return false;
            }
        }
        return true;

    }
}
