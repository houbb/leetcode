package com.github.houbb.leetcode.topics.matrix;

import java.util.ArrayList;
import java.util.List;

public class T54_spiralOrder_V1_BF {

    public List<Integer> spiralOrder(int[][] matrix) {
        // 如何遍历
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = matrix.length-1;
        int colEnd = matrix[0].length-1;

        List<Integer> resultList = new ArrayList<>();

        int totalSize = matrix.length * matrix[0].length;
        while (resultList.size() < totalSize) {
            // 处理
            // 1. 从左到右遍历
            for(int i = colStart; i <= colEnd; i++) {
                if(resultList.size() >= totalSize) {
                    return resultList;
                }
                resultList.add(matrix[rowStart][i]);
            }
            // 第一行结束
            rowStart++;

            // 2. 从右-》下
            for(int i = rowStart; i <= rowEnd; i++) {
                if(resultList.size() >= totalSize) {
                    return resultList;
                }
                resultList.add(matrix[i][colEnd]);
            }
            // 最后一列结束
            colEnd--;

            // 3. 从下往左
            for(int i = colEnd; i >= colStart; i--) {
                if(resultList.size() >= totalSize) {
                    return resultList;
                }
                resultList.add(matrix[rowEnd][i]);
            }
            rowEnd--;

            // 4. 从左->上
            for(int i = rowEnd; i >= rowStart; i--) {
                if(resultList.size() >= totalSize) {
                    return resultList;
                }
                resultList.add(matrix[i][colStart]);
            }
            colStart++;
        }

        return resultList;
    }


}
