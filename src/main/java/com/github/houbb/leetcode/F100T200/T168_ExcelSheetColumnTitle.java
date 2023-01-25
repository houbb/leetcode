package com.github.houbb.leetcode.F100T200;

public class T168_ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();

        while (columnNumber > 0) {
            // excel 从1开始
            columnNumber--;

            // 插入值
            stringBuilder.append((char) ('A' + columnNumber % 26));

            columnNumber = columnNumber / 26;
        }

        return stringBuilder.reverse().toString();
    }


}
