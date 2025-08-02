package com.github.houbb.leetcode.topics.slidlingWindows;

import java.util.HashMap;
import java.util.Map;

public class T76_MinimumWindowSubstring_V2_BF_OptCondition_V2 {

    public static void main(String[] args) {
        T76_MinimumWindowSubstring_V2_BF_OptCondition_V2 v1Bf = new T76_MinimumWindowSubstring_V2_BF_OptCondition_V2();
        String result = v1Bf.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(result);
    }

    /**
     * 返回 s 中涵盖 t 所有字符的最小子串。
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        char[] tcs = t.toCharArray();
        final Map<Character, Integer> targetCountMap = new HashMap<>();
        for(char c : tcs) {
            Integer count = targetCountMap.getOrDefault(c, 0);
            count++;
            targetCountMap.put(c, count);
        }

        String result = null;
        int left = 0;
        Map<Character, Integer> tempMap = new HashMap<>();
        for(int right = 0; right < s.length(); right++) {
            addChar(s, right, tempMap);

            // 判断多少个字符满足条件，这里只是为了加速判断，先不做也行

            // 满足条件
            if(isMatchCondition(tempMap, targetCountMap)) {
                // 当条件满足的时候，可以尝试让 left 指针像右移动。一直到条件不符合的时候终止，此时 left 在最右边，距离最短。
                // 此时类似于模拟出栈
                while (isMatchCondition(tempMap, targetCountMap)) {
                    removeChar(s, left, tempMap);
                    left++;
                }
                // 恢复正常位置
                left--;
                addChar(s, left, tempMap);

                // 满足
                if(result == null) {
                    result = buildString(s, left, right);
                } else {
                    int len = right-left+1;
                    if(result.length() > len) {
                        result = buildString(s, left, right);
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

    private void addChar(String s,
                            int index,
                            Map<Character, Integer> tempMap) {
        char c = s.charAt(index);
        Integer curCount = tempMap.getOrDefault(c, 0);
        curCount++;
        tempMap.put(c, curCount);
    }

    private void removeChar(String s,
                            int index,
                            Map<Character, Integer> tempMap) {
        char c = s.charAt(index);
        Integer curCount = tempMap.getOrDefault(c, 0);
        curCount--;
        tempMap.put(c, curCount);
    }

    // 这个应该也可以优化 这里为了逻辑清晰。先不优化
    private String buildString(String s, int left, int right) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = left; i <= right; i++) {
            char c = s.charAt(i);
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    // 后续可以用有多少个字符满足来加速判断，这里为了逻辑清晰。先不加。
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
