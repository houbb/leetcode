package com.github.houbb.leetcode.F100T200;

public class T171_ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        // 从1开始
        int sum = 1;

        // 倒叙遍历
        int count = 0;
        for(int i = columnTitle.length()-1; i >= 0; i--) {
            int val = (int)(columnTitle.charAt(i) - 'A');

            sum += val * Math.pow(26, count);
            count++;
        }

        return sum;
    }

}
