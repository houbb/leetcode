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
public class T006_ZigzagConversionV3 {


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
