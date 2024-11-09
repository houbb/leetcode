package com.github.houbb.leetcode.F1300T1400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T_1371_findTheLongestSubstring_V2 {


    private void toggleState(int[] states, int index) {
        states[index] = states[index] == 1 ? 0 : 1;
    }

    /**
     * 构建对应的数组
     *
     * 子数组：所以使用前缀和来解决？
     * @param s
     * @return
     */
    public int findTheLongestSubstring(String s) {
        // 如果是拆分为5个数组呢？
        final int len = s.length();
        char[] chars = s.toCharArray();

        // 状态数组
        int[] states = new int[5];
        Map<String, Integer> map = new HashMap<>();

        // 初始化

        int maxLen = 0;
        for(int i = 0; i < len; i++) {
            char c = chars[i];

            if(c == 'a') {
                toggleState(states, 0);
            }else if(c == 'e') {
                toggleState(states, 1);
            }else if(c == 'i') {
                toggleState(states, 2);
            }else if(c == 'o') {
                toggleState(states, 3);
            }else if(c == 'u') {
                toggleState(states, 4);
            }

            // 如果已经有 说明差值相同
            String stateString = Arrays.toString(states);
            if(map.containsKey(stateString)) {
                maxLen = Math.max(maxLen, i - map.get(stateString));
            }

            // 记录状态
            map.put(stateString, i);
        }

        return maxLen;
    }

}
