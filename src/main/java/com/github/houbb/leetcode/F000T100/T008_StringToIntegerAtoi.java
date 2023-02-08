package com.github.houbb.leetcode.F000T100;

/**
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-10 13:53:17
 */
public class T008_StringToIntegerAtoi {

    /**
     * 开始符号
     * @since v1
     */
    private static final char[] START_CHARS = "+-0123456789".toCharArray();

    /**
     * 中间符号
     * @since v1
     */
    private static final char[] NUM_CHARS = "0123456789".toCharArray();

    /**
     * 简单解法：
     *
     * 1. trim 空格
     * 2. 遍历 char，如果是 【1234567890-+】，则进行保留。
     * 第一个数字必须是数字符号，否则直接跳出。
     *
     * 3. 如果遇到空格，则跳出当前循环。
     *
     * 4. 越界处理
     *
     * 如果 +，超过最大值，则返回 {@link Integer#MAX_VALUE}
     * 如果 -，超过最小值，则返回 {@link Integer#MIN_VALUE}
     *
     * 效果：
     *
     * Runtime: 4 ms, faster than 25.49% of Java online submissions for String to Integer (atoi).
     * Memory Usage: 39.4 MB, less than 73.49% of Java online submissions for String to Integer (atoi).
     *
     * @param str 字符串
     * @return 结果
     * @since v1
     */
    public int myAtoi(String str) {
        String trim = str.trim();

        final int length = trim.length();
        if(length <= 0) {
            return 0;
        }

        // 符号标识
        boolean isPositive = true;
        char firstChar = trim.charAt(0);
        if(!contains(START_CHARS, firstChar)) {
            return 0;
        }

        StringBuilder stringBuilder = new StringBuilder(trim.length());
        if(firstChar == '+' || firstChar == '0') {
            //do nothing
        } else if(firstChar == '-') {
            isPositive = false;
        } else {
            stringBuilder.append(firstChar);
        }

        for(int i = 1; i < length; i++) {
            char currentChar = trim.charAt(i);
            if(contains(NUM_CHARS, currentChar)) {
                // 如果符号一直是 0，则忽略
                if('0' == currentChar && stringBuilder.length() == 0) {
                    continue;
                }
                stringBuilder.append(currentChar);
            } else {
                break;
            }
        }
        // 特殊处理
        final int bufferLen = stringBuilder.length();
        if(bufferLen <= 0) {
            return 0;
        }
        // 超长（10）,Integer 的最大值为 10
        if(bufferLen > 11) {
            if(isPositive) {
                return Integer.MAX_VALUE;
            }
            return Integer.MIN_VALUE;
        }

        // 转换处理
        String numStr = stringBuilder.toString();
        if(!isPositive) {
            numStr = "-"+numStr;
        }
        long parseLong = Long.parseLong(numStr);
        if(parseLong > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if(parseLong < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) parseLong;
    }

    /**
     * 是否包含指定的元素
     * @param chars 字符数组
     * @param c 字符
     * @return 结果
     * @since v1
     */
    private boolean contains(final char[] chars,
                             final char c) {
        for(char c2 : chars) {
            if(c2 == c) {
                return true;
            }
        }
        return false;
    }

}
