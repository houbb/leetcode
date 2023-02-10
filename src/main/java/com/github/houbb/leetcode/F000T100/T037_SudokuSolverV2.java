package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.util.MultiArrays;

/**
 * @author d
 * @since 1.0.0
 */
public class T037_SudokuSolverV2 {

    public static void main(String[] args) {
        char[][] board1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        T037_SudokuSolverV2 validSoduku = new T037_SudokuSolverV2();
        validSoduku.solveSudoku(board1);
        MultiArrays.show(board1);
    }

    boolean[][] rowUsed = new boolean[9][10];
    boolean[][] colUsed = new boolean[9][10];
    boolean[][][] boxUsed = new boolean[3][3][10];
    char[][] board;

    public void solveSudoku(char[][] _board) {
        board = _board;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.') {
                    int num = (int)(board[i][j] - '0');
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    boxUsed[i/3][j/3][num] = true;
                }
            }
        }
        backtracking(0, 0);
    }

    boolean backtracking(int row, int col) {
        // 列到达末尾，则换下一行进行处理。
        if(col == board[0].length) {
            col = 0;
            row++;

            // 最后结束，终止条件
            if(row == board.length) {
                return true;
            }
        }

        // 待填入的位置
        if(board[row][col] == '.') {
            // 尝试 9 种数字
            for(int i = 1; i <= 9; i++) {
                boolean canUse = !(rowUsed[row][i] || colUsed[col][i] || boxUsed[row/3][col/3][i]);

                // 在每行、列、小9宫格可以填写的数字。
                if(canUse) {
                    // 使用
                    board[row][col] = (char)(i + '0');
                    rowUsed[row][i] = true;
                    colUsed[col][i] = true;
                    boxUsed[row/3][col/3][i] = true;
                    // 回溯
                    if(backtracking(row, col + 1)) {
                        return true;
                    }

                    // 清空
                    board[row][col] = '.';
                    rowUsed[row][i] = false;
                    colUsed[col][i] = false;
                    boxUsed[row/3][col/3][i] = false;
                }
            }
        } else {
            // 继续下一列
            return backtracking(row, col + 1);
        }
        return false;
    }

}
