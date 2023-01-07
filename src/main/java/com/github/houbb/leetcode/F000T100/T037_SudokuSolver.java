package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.util.MultiArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author d
 * @since 1.0.0
 */
public class T037_SudokuSolver {

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

        T037_SudokuSolver validSoduku = new T037_SudokuSolver();
        validSoduku.solveSudoku(board1);
        MultiArrays.show(board1);
    }

    /**
     * 基本思路：
     *
     * 1. 这一题应该需要回溯？
     *
     * 2. i,j 位置的元素。首先通过 行、列、小九宫格，来把一个位置可行的元素过滤出来，放在 set 中。
     *
     * 3. 尝试在这个位置放入一个元素，然后依次放剩下的。如果可以，则可行，如果不行，则回溯重来。
     *
     * 3.1 完成的条件。放入的元素个数，刚好等于初始 . 的个数
     * @param board 棋盘
     */
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }

    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell

                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }

}
