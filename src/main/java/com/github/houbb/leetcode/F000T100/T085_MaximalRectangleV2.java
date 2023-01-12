package com.github.houbb.leetcode.F000T100;

public class T085_MaximalRectangleV2 {

    /**
     * 最大的长方形
     *
     * 优化思路：缓存对于是否全部为 1 的判断
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

                // 是否都为1的缓存
                boolean[][] allOneDp = new boolean[rowSize][columnSize];

                // 从当前位置开始，向右向下遍历。
                for(int x = i; x < rowSize; x++) {
                    for(int y = j; y < columnSize; y++) {
                        allOneDp[x][y] = matrix[x][y] == '1';

                        // 复用以前的
                        if(x > i) {
                            allOneDp[x][y] = allOneDp[x][y] & allOneDp[x-1][y];
                        }
                        if(y > j) {
                            allOneDp[x][y] = allOneDp[x][y] & allOneDp[x][y-1];
                        }

                        // 如果满足，则计算更新
                        if(allOneDp[x][y]) {
                            maxArea = Math.max(maxArea, (x-i+1)*(y-j+1));
                        }
                    }
                }
            }
        }

        return maxArea;
    }

}
