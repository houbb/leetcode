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
public class T006_ZigzagConversionV2 {

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
    public String convert(String s, int numRows) {
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

}
