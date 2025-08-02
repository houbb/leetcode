package com.github.houbb.leetcode.topics.slidlingWindows;

import java.util.HashMap;
import java.util.Map;

public class T76_MinimumWindowSubstring_V3_SlidingWindowsOpt {

    public static void main(String[] args) {
        T76_MinimumWindowSubstring_V3_SlidingWindowsOpt v1Bf = new T76_MinimumWindowSubstring_V3_SlidingWindowsOpt();
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
        int matchCharCount = 0;

        for(int right = 0; right < s.length(); right++) {
            // 判断多少个字符满足条件，这里只是为了加速判断，先不做也行
            char c = s.charAt(right);
            Integer curCount = tempMap.getOrDefault(c, 0);
            curCount++;
            tempMap.put(c, curCount);
            // 刚好等于时+1
            if(targetCountMap.containsKey(c)
                && targetCountMap.get(c).equals(curCount)) {
                matchCharCount++;
            }

            // 满足条件
            if(matchCharCount == targetCountMap.size()) {
                // 当条件满足的时候，可以尝试让 left 指针像右移动。一直到条件不符合的时候终止，此时 left 在最右边，距离最短。
                // 此时类似于模拟出栈
                while (matchCharCount == targetCountMap.size()) {
                    char leftChar = s.charAt(left);

                    int leftCharCount = tempMap.getOrDefault(leftChar, 0);
                    leftCharCount--;
                    tempMap.put(leftChar, leftCharCount);
                    // +1 刚好等于目标
                    if(targetCountMap.containsKey(leftChar)
                            && targetCountMap.get(leftChar).equals(leftCharCount+1)) {
                        matchCharCount--;
                    }

                    // 向右移动
                    left++;
                }
                // 恢复正常位置
                left--;
                char leftRecoveryChar = s.charAt(left);
                tempMap.put(leftRecoveryChar, targetCountMap.get(leftRecoveryChar));
                matchCharCount++;

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


    // 这个应该也可以优化 这里为了逻辑清晰。先不优化
    private String buildString(String s, int left, int right) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = left; i <= right; i++) {
            char c = s.charAt(i);
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

}
