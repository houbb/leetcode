package com.github.houbb.leetcode.F000T100;

/**
 * 以 Z 字形从上到下排列字符，返回的时候从左到右。
 *
 * <p> project: leetcode-ZigzagConversion </p>
 * <p> create on 2020/6/9 23:52 </p>
 *
 * @author binbin.hou
 * @since v1
 */
public class T006_ZigzagConversion {

    /**
     * 简单思路：
     *
     * 将其看做一个二维数组。
     *
     * 什么是 Z 字型？
     * ABCDEFGHI
     *
     * 三个：
     * 1 2 3 4 5
     * A   E   I
     * B D F H J
     * C   G   K
     *
     * 四个：
     * 1 2 3  4  5
     * A      G
     * B   F  H
     * C E    I  K
     * D      J
     *
     *
     * 效果：
     *
     * Runtime: 49 ms, faster than 9.25% of Java online submissions for ZigZag Conversion.
     * Memory Usage: 41.7 MB, less than 19.65% of Java online submissions for ZigZag Conversion.
     *
     * @param s 字符串
     * @param numRows 多少行
     * @return 结果
     * @since v1
     */
    public String convert(String s, int numRows) {
        if(s.length() <= 1 || numRows <= 1) {
            return s;
        }

        // 这里的多少列是个技术活，需要思考一下。
        final int length = s.length();
        char[][] zChars = new char[numRows][length];

        char[] chars = s.toCharArray();

        int rowIndex = 0;
        int colIndex = 0;
        boolean isDown = true;

        // 第一个位置
        zChars[rowIndex][colIndex] = chars[0];
        for(int i = 1; i < length; i++) {
            char c = s.charAt(i);
            // 第一行时，从上到下
            if(rowIndex == 0) {
                isDown = true;
            } else if(rowIndex == numRows-1) {
                isDown = false;
            }

            // 处于向下的过程
            if(isDown) {
                rowIndex++;
            } else {
                // 处于向上的过程
                // 最后一行时，从下到上，从左到右
                colIndex++;
                rowIndex--;
            }
            zChars[rowIndex][colIndex] = c;
        }

        // 空元素 '\0'
        // 从左到右，从上到下遍历。
        StringBuilder stringBuilder = new StringBuilder(length);
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < length; j++) {
                char currentChar = zChars[i][j];
                if(currentChar != '\0') {
                    stringBuilder.append(currentChar);
                }
            }
        }

        return stringBuilder.toString();
    }

    /**
     * 优化数组整体的列数
     *
     * 效果：（不明显）
     * Runtime: 51 ms, faster than 9.05% of Java online submissions for ZigZag Conversion.
     * Memory Usage: 52.6 MB, less than 5.00% of Java online submissions for ZigZag Conversion.
     *
     * 效果2：（略有提升）
     *
     * Runtime: 16 ms, faster than 21.83% of Java online submissions for ZigZag Conversion.
     * Memory Usage: 40.1 MB, less than 41.98% of Java online submissions for ZigZag Conversion.
     *
     * @param s 字符串
     * @param numRows 行数
     * @return 结果
     * @since v2
     */
    public String convertOptimize(String s, int numRows) {
        //fast-return
        if(s.length() <= 1 || numRows <= 1) {
            return s;
        }
        final int length = s.length();
        if(numRows >= length) {
            return s;
        }

        // 这里的多少列是个技术活，需要思考一下。
        final int numCols = (length+1) >> 1;
        char[][] zChars = new char[numRows][numCols];

        char[] chars = s.toCharArray();

        int rowIndex = 0;
        int colIndex = 0;
        boolean isDown = true;

        // 第一个位置
        zChars[rowIndex][colIndex] = chars[0];
        for(int i = 1; i < length; i++) {
            char c = s.charAt(i);
            // 第一行时，从上到下
            if(rowIndex == 0) {
                isDown = true;
            } else if(rowIndex == numRows-1) {
                isDown = false;
            }

            // 处于向下的过程
            if(isDown) {
                rowIndex++;
            } else {
                // 处于向上的过程
                // 最后一行时，从下到上，从左到右
                colIndex++;
                rowIndex--;
            }
            zChars[rowIndex][colIndex] = c;
        }

        // 空元素 '\0'
        // 从左到右，从上到下遍历。
        // 此处的列直接根据上述遍历的最大值获取。
        StringBuilder stringBuilder = new StringBuilder(length);
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < colIndex+1; j++) {
                char currentChar = zChars[i][j];
                if(currentChar != '\0') {
                    stringBuilder.append(currentChar);
                }
            }
        }

        return stringBuilder.toString();
    }


}
