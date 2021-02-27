package com.github.houbb.leetcode.medium;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class ValidSoduku {

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


        ValidSoduku validSoduku = new ValidSoduku();
        System.out.println(validSoduku.isValidSudoku(board1));
    }

    public boolean isValidSudoku(char[][] board) {
        //1. 每一行
        for(int i = 0; i < 9; i++) {
            char[] row = board[i];

            if(!isValid(row)) {
                return false;
            }
        }

        //2. 每一列
        for(int i = 0; i < 9; i++) {
            char[] columns = getColumns(board, i);
            if(!isValid(columns)) {
                return false;
            }
        }

        //3. 每一个小的 9 宫格
        for(int i = 0; i < 9; i++) {
            char[] box = getSubBox(board, i);
            if(!isValid(box)) {
                return false;
            }
        }


        return true;
    }

    /**
     * 获取小9宫格
     *
     * 规律：
     *
     * 0    00 01 02
     *      10 11 12
     *      20 21 22
     *
     * 2 （第二行，第一个九宫格）
     *
     * 根据 index 获取对应的行+列信息
     *
     * row:  0 1 2
     *       3 4 5
     *       6 7 8
     *
     * @param board
     * @param index
     * @return
     */
    private char[] getSubBox(char[][] board, int index) {
        char[] box = new char[9];
        int size = 0;

        int rowNum = index/3;
        int columnNum = index%3;

        for(int i = rowNum*3; i < rowNum*3+3; i++) {
            for(int j = columnNum*3; j < columnNum*3+3; j++) {
                box[size++] = board[i][j];
            }
        }
        return box;
    }

    /**
     * 获取指定的列
     * @param board
     * @param columnIndex
     * @return
     */
    private char[] getColumns(char[][] board, int columnIndex) {
        char[] columns = new char[9];
        int size = 0;
        for(int i = 0; i < 9; i++) {
            char[] rows = board[i];
            columns[size++] = rows[columnIndex];
        }
        return columns;
    }

    /**
     * 只能包含：. 1-9
     *
     * 不能重复  主要是这个
     * @param chars
     * @return
     */
    private boolean isValid(char[] chars) {
        char[] nums = new char[9];
        int numSize = 0;
        for(char c : chars) {
            if(!isValidChar(c)) {
                return false;
            }

            // 忽略处理 .
            if('.' == c) {
                continue;
            }

            // 数据重复
            if(contains(nums, c)) {
                return false;
            }

            nums[numSize++] = c;
        }

        // 合法
        return true;
    }

    /**
     * 合法的值：. 或者 1-9
     * @param c
     * @return
     */
    private boolean isValidChar(char c) {
        if('.' == c) {
            return true;
        }

        if('1' <= c && c <= '9') {
            return true;
        }

        return false;
    }

    /**
     * 是否包含
     * @param chars
     * @param target
     * @return
     */
    private boolean contains(char[] chars, char target) {
        for(char c : chars) {
            if(target == c) {
                return true;
            }
        }

        return false;
    }


}
