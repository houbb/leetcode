package com.github.houbb.leetcode;

/**
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-10 13:53:17
 */
public class StringToIntegerAtoiOptimize {

    /**
     *
     * 优化:
     *
     * Runtime: 2 ms, faster than 81.23% of Java online submissions for String to Integer (atoi).
     * Memory Usage: 40.2 MB, less than 11.48% of Java online submissions for String to Integer (atoi).
     * @param str 字符串
     * @return 结果
     * @since v1
     */
    public int myAtoi(String str) {
        int n = 0;
        str = str.trim();
        boolean isPositive = true;

        // 遍历处理
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch != '+' && ch != '-' && ch < '0' || ch > '9') {
                break;
            } else {
                if('+' == ch) {
                    if(i == 0) {
                        continue;
                    } else {
                        break;
                    }
                }
                if('-' == ch) {
                    if(i == 0) {
                        isPositive = false;
                        continue;
                    } else {
                        break;
                    }
                }

                // 计算 && 越界处理
                if(n * 10L + ch - 48 > Integer.MAX_VALUE) {
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                n = n * 10 + ch - 48;
            }
        }

        return isPositive ? n : -n;
    }

}
