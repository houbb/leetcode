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
    public String convertBasic(String s, int numRows) {
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

    /**
     * 优化思路：拼接的时候其实在同一行的可以直接添加，没必要 O(N^2) 次遍历。
     * 这就涉及到如何在插入的时候完成拼接。
     *
     * Runtime: 9 ms, faster than 43.72% of Java online submissions for ZigZag Conversion.
     * Memory Usage: 40.5 MB, less than 24.44% of Java online submissions for ZigZag Conversion.
     *
     * 【效果2】
     *
     * 优化点：数组替代LIST   append String 替代 buffer
     *
     * Runtime: 6 ms, faster than 57.03% of Java online submissions for ZigZag Conversion.
     * Memory Usage: 41.5 MB, less than 20.23% of Java online submissions for ZigZag Conversion.
     *
     * @param s 字符串
     * @param numRows 行
     * @return 结果
     * @since v3
     */
    public String convert2(String s, int numRows) {
        //fast-return
        final int length = s.length();
        if(s.length() <= 1 || numRows <= 1 || numRows >= length) {
            return s;
        }

        // 这里使用 buffer 替代。
        StringBuilder[] stringBuilderList = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            StringBuilder builder = new StringBuilder(length);
            stringBuilderList[i] =builder;
        }

        int rowIndex = 0;
        boolean isDown = true;

        // 第一个位置
        stringBuilderList[0].append(s.charAt(0));
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
                rowIndex--;
            }

            // 只需要关心属于对应的行即可
            // 行在变化，但是列肯定是在增长的。
            stringBuilderList[rowIndex].append(c);
        }

        // 按照行拼接
        StringBuilder stringBuilder = new StringBuilder(length);
        for(StringBuilder part : stringBuilderList) {
            // 这里直接拼接字符串其实更快。
            stringBuilder.append(part.toString());
        }

        return stringBuilder.toString();
    }

    /**
     * 效果：
     *
     * Runtime: 9 ms, faster than 43.93% of Java online submissions for ZigZag Conversion.
     * Memory Usage: 41 MB, less than 20.77% of Java online submissions for ZigZag Conversion.
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert3(String s, int numRows) {
        final int length = s.length();
        if(numRows == 1) {
            return s;
        }

        int minRows = Math.min(numRows, length);
        StringBuilder[] stringBuilderList = new StringBuilder[minRows];
        for(int i = 0; i < minRows; i++) {
            stringBuilderList[i] = new StringBuilder(length);
        }

        int rowIndex = 0;
        boolean isDown = false;
        stringBuilderList[0].append(s.charAt(0));
        for(int i = 1; i < length; i++) {
            if(rowIndex == 0 || rowIndex == numRows-1) {
                isDown = !isDown;
            }

            if(isDown) {
                rowIndex++;
            } else {
                rowIndex--;
            }

            stringBuilderList[rowIndex].append(s.charAt(i));
        }

        StringBuilder stringBuilder = stringBuilderList[0];
        for(int i = 1; i < stringBuilderList.length; i++) {
            stringBuilder.append(stringBuilderList[i].toString());
        }
        return stringBuilder.toString();
    }

    /**
     * 结果
     *
     * Visit all characters in row 0 first, then row 1, then row 2, and so on...
     *
     * For all whole numbers kk,
     *
     * Characters in row 0 are located at indexes k(2⋅numRows−2)
     * Characters in row numRows−1 are located at indexes k(2⋅numRows−2)+numRows−1
     * Characters in inner row i are located at indexes k(2⋅numRows−2)+i
     * and (k+1)(2⋅numRows−2)−i.
     *
     * Runtime: 2 ms, faster than 99.85% of Java online submissions for ZigZag Conversion.
     * Memory Usage: 39.1 MB, less than 99.38% of Java online submissions for ZigZag Conversion.
     *
     * @param s 原始字符串
     * @param numRows 行
     * @return 结果
     * @since v4
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int n = s.length();
        StringBuilder ret = new StringBuilder(n);

        // 每一行的循环长度（这是一个规律）  k(2⋅numRows−2)
        int cycleLen = (numRows << 1) - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                // 所有行都符合
                ret.append(s.charAt(j + i));

                // 非第一行 && 非最后一行
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }

        return ret.toString();
    }

    /**
     * 使用 chars[] 替代 Buffer。差异不大
     *
     * Runtime: 2 ms, faster than 99.85% of Java online submissions for ZigZag Conversion.
     * Memory Usage: 39.5 MB, less than 90.65% of Java online submissions for ZigZag Conversion.
     * @param s 字符串
     * @param numRows 行
     * @return 结果
     * @since v5
     */
    public String convertV5(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int n = s.length();
        char[] chars = new char[n];
        int cycleLen = (numRows << 1) - 2;

        int charIndex = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                chars[charIndex++] = s.charAt(j + i);

                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    chars[charIndex++] = s.charAt(j + cycleLen - i);
                }
            }
        }

        return new String(chars);
    }

}
