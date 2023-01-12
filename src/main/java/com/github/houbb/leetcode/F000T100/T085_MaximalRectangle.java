package com.github.houbb.leetcode.F000T100;

public class T085_MaximalRectangle {

    private boolean isAllOnes(char[][] matrix,
                              int xStart,
                              int xEnd,
                              int yStart,
                              int yEnd) {
        for(int x = xStart; x <= xEnd; x++) {
            for(int y = yStart; y <= yEnd; y++) {
                if(matrix[x][y] == '0') {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 最大的长方形
     * @param matrix 矩阵
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;

        // 行
        int rowSize = matrix.length;
        // 列
        int columnSize = matrix[0].length;

        // 直接遍历整个矩阵
        for(int i = 0; i < rowSize; i++) {
            for(int j = 0; j < columnSize; j++) {
                // 当前位置为0，则跳过
                if(matrix[i][j] == '0') {
                    continue;
                }

                // 从当前位置开始，向右向下遍历。
                for(int x = i; x < rowSize; x++) {
                    for(int y = j; y < columnSize; y++) {
                        // 跳过为0的元素
                        if(matrix[x][y] == '0') {
                            continue;
                        }

                        // 判断从 横介于[i,x]，纵介于[j,y]的矩阵。
                        // 如果这个矩阵都是1，则计算更新对应的 area。
                        if(isAllOnes(matrix, i, x, j, y)) {
                            int area = (x-i+1) * (y-j + 1) ;
                            maxArea = Math.max(maxArea, area);
                        }
                    }
                }
            }
        }

        return maxArea;
    }



}
