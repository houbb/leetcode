package com.github.houbb.leetcode.F000T100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author d
 * @since 1.0.0
 */
public class T051_NQueens {

    public static void main(String[] args) {
        System.out.println(new T051_NQueens().solveNQueens(4));
    }

    /**
     * n 皇后问题
     *
     * 1. 根据 n 初始化 board 棋盘
     * 2. backtrack 处理
     *
     * 2.1 逐行处理，在 colIndex 位置放入元素。判断是否合法，合法则继续
     * 2.2 colIndex 最后一列时，说明处理完成。
     *
     * 【核心逻辑】
     * 如何判断是否合法
     *
     * 1. 同行没有重复
     * 2. 同列没有重复
     * 3. 对角没有重复
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        char[][] board = initBoard(n);

        List<List<String>> resultList = new ArrayList<>();
        backtrack(board, 0, resultList);

        return resultList;
    }

    /**
     * 回溯
     * @param board 棋盘
     * @param colIndex 列索引
     * @param resultList 结果
     */
    private void backtrack(char[][] board,
                           int colIndex,
                           List<List<String>> resultList) {
        if(colIndex == board.length) {
            // 满足条件
            List<String> stringList = boardToList(board);
            resultList.add(stringList);
            return;
        }

        // 逐行处理
        for(int i = 0; i < board.length; i++) {
            if(validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';

                backtrack(board, colIndex+1, resultList);
                // 移除
                board[i][colIndex] = '.';
            }
        }
    }

    private List<String> boardToList(char[][] board) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            String string = new String(chars);
            list.add(string);
        }
        return list;
    }

    /**
     * The reason it checks (x + j == y + i || x + y == i + j || x == i):
     *
     * Every time we find a existing 'Q', 3 conditions need to be met before we can place a new 'Q' in the new column:
     *
     * no confict in columns : self explanatory as we put 'Q' col by col.
     *
     * no confict in rows : x == i
     *
     * no conflict in diagonals : Math.abs(x-i) == Math.abs(y-j)
     *
     * For Math.abs(x-i) == Math.abs(y-j),
     * if x > i, y > j , x - i = y - j => x + j = y + i
     * if x < i, y < j, i - x = j - y => x + j = y + i
     * if x > i, y < j, x - i = j - y => x + y = i + j
     * if x < i, y > j, i - x = y - j => x + y = i + j
     *
     * @param board
     * @param x
     * @param y
     * @return
     */
    private boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                if(board[i][j] == 'Q'
                        && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }

        return true;
    }

    private char[][] initBoard(int n) {
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        return board;
    }

}
