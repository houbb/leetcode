package com.github.houbb.leetcode.topics.slidlingWindows;

import java.util.HashMap;
import java.util.Map;

public class T76_MinimumWindowSubstring_V2_BF_OptCondition {

    public static void main(String[] args) {
        T76_MinimumWindowSubstring_V2_BF_OptCondition v1Bf = new T76_MinimumWindowSubstring_V2_BF_OptCondition();
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
        Map<Character, Integer> targetCountMap = new HashMap<>();
        for(char c : tcs) {
            Integer count = targetCountMap.getOrDefault(c, 0);
            count++;
            targetCountMap.put(c, count);
        }

        String result = null;
        int left = 0;
        int right = 0;
        for(left = 0; left < s.length(); left++) {
            // 然后判断
            Map<Character, Integer> tempTargetCountMap = new HashMap<>(targetCountMap);
            StringBuilder stringBuilder = new StringBuilder();

            for(right = left; right < s.length(); right++) {
                char c = scs[right];
                stringBuilder.append(c);

                Integer count = tempTargetCountMap.get(c);
                if(count != null) {
                    count--;
                    tempTargetCountMap.put(c, count);

                    if(count == 0) {
                        tempTargetCountMap.remove(c);
                    }
                }

                if(tempTargetCountMap.isEmpty()) {
                    // 满足
                    if(result == null) {
                        result = stringBuilder.toString();
                    } else {
                        if(result.length() > stringBuilder.length()) {
                            result = stringBuilder.toString();
                        }
                    }
                    // 当前循环终止
                    break;
                }
            }
        }

        // 默认为空
        if(result == null) {
            result = "";
        }
        return result;
    }

}
