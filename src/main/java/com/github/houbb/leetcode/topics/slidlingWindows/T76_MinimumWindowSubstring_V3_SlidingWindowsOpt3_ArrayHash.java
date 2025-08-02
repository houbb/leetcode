package com.github.houbb.leetcode.topics.slidlingWindows;

public class T76_MinimumWindowSubstring_V3_SlidingWindowsOpt3_ArrayHash {

    public static void main(String[] args) {
        T76_MinimumWindowSubstring_V3_SlidingWindowsOpt3_ArrayHash v1Bf = new T76_MinimumWindowSubstring_V3_SlidingWindowsOpt3_ArrayHash();
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
        int[] targetCountMap = new int[128];
        for(char c : tcs) {
            targetCountMap[c]++;
        }
        // 这里用 set 会更快吗？
        int targetCharSize = 0;
        for(int i = 0; i < 128; i++) {
            if(targetCountMap[i] > 0) {
                targetCharSize++;
            }
        }

        String result = null;
        int left = 0;
        int[] tempMap = new int[128];
        int matchCharCount = 0;

        for(int right = 0; right < s.length(); right++) {
            // 入
            char c = s.charAt(right);
            tempMap[c]++;
            // 刚好等于时+1
            if(targetCountMap[c] > 0
                    && targetCountMap[c] == tempMap[c]) {
                matchCharCount++;
            }

            // 满足条件
            if(matchCharCount == targetCharSize) {
                // 当条件满足的时候，可以尝试让 left 指针像右移动。一直到条件不符合的时候终止，此时 left 在最右边，距离最短。
                // 此时类似于模拟出栈
                while (matchCharCount == targetCharSize) {
                    // 移除字符
                    char leftChar = s.charAt(left);
                    tempMap[leftChar]--;
                    // +1 刚好等于目标
                    if(targetCountMap[leftChar] > 0
                            && targetCountMap[leftChar] == (tempMap[leftChar]+1)) {
                        matchCharCount--;
                    }

                    // 向右移动
                    left++;
                }
                // 恢复正常位置
                left--;
                char leftRecoveryChar = s.charAt(left);
                tempMap[leftRecoveryChar] = targetCountMap[leftRecoveryChar] ;
                matchCharCount++;

                // 满足
                if(result == null) {
                    result = s.substring(left, right + 1);
                } else {
                    int len = right-left+1;
                    if(result.length() > len) {
                        result = s.substring(left, right + 1);
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

}
