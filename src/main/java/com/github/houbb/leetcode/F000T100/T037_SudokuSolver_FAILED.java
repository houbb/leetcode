package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.util.MultiArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author d
 * @since 1.0.0
 */
public class T037_SudokuSolver_FAILED {

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

        T037_SudokuSolver_FAILED validSoduku = new T037_SudokuSolver_FAILED();
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
     *
     * 3.2 dp 能否记录一下可行性？
     *
     * @param board 棋盘
     */
    public void solveSudoku(char[][] board) {
        // 存放填充的结果
        List<Character> tempList = new ArrayList<>();

        List<List<Integer>> todoList = todoList(board);

        // backtrack
        backtrack(board, todoList, tempList, 0);
    }

    /**
     * 指定一个位置，可以用的数字列表
     * @param board
     * @param positionList
     * @return
     */
    private List<Character> getUseNumList(char[][] board,
                                          List<Integer> positionList) {
        // 获取当前位置，支持添加的元素信息
        List<Character> resultList = new ArrayList<>();
        char[] allChars = "123456789".toCharArray();

        // 位置
        int x = positionList.get(0);
        int y = positionList.get(1);

        // 去掉当前行已有的数字
        // 当前行
        char[] rows = board[x];
        char[] columns = getColumns(board, y);
        char[] subBoxes = getSubBox(board, x);

        for(char c : allChars) {
            if(!containsChar(rows, c)
                && !containsChar(columns, c)
                && !containsChar(subBoxes, c)) {

                resultList.add(c);
            }
        }

        return resultList;
    }

    private boolean containsChar(char[] chars, char c) {
        for(char cs : chars) {
            if(cs == c) {
                return true;
            }
        }
        return false;
    }

    /**
     * 构建需要处理的结果集合
     *
     * 0 (1,2) 存放2个元素，对应 i,j 位置
     * @param board 棋盘
     * @return 结果
     */
    private List<List<Integer>> todoList(char[][] board) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    list.add(Arrays.asList(i, j));
                }
            }
        }

        return list;
    }

    /**
     * 最后把结果更新好
     * @param board 棋盘
     * @param todoList 待处理列表
     * @param resultList 结果集合
     */
    private void fillResultBoard(char[][] board,
                                 List<List<Integer>> todoList,
                                 List<Character> resultList) {
        for(int i = 0; i < resultList.size(); i++) {
            List<Integer> position = todoList.get(i);
            board[position.get(0)][position.get(1)] = resultList.get(i);
        }
    }

    /**
     * 回溯
     * @param board 棋盘
     * @param todoList 横
     * @param tempList 临时列表
     * @param startIndex 开始下标，这里根据待处理的数字 set 处理，先做实时计算。后续性能不足，再做 mm。e
     */
    private void backtrack(char[][] board,
                           List<List<Integer>> todoList,
                           List<Character> tempList,
                           int startIndex) {
        // 截止条件 元素刚好和待处理的一样多
        if(tempList.size() >= todoList.size()) {
            List<Character> resultList = new ArrayList<>(tempList);
            // 填充结果
            fillResultBoard(board, todoList, resultList);
            return;
        }

        // 获取当前位置可用的字典
        // 遍历所有可用的单词
        // 待选择的数字列表
        List<Integer> position = todoList.get(tempList.size());
        List<Character> useNumList = getUseNumList(board, position);
        if(startIndex > useNumList.size()) {
            // 没有可以选择的数字，这个路不可行。
            return;
        }

        for(int i = 0; i < useNumList.size(); i++) {
            // 选择一个可用的数字
            char numChar = useNumList.get(i);

            tempList.add(numChar);

            // 什么时候放下一个元素？
            // 下一次回溯
            backtrack(board, todoList, tempList, startIndex+1);

            // 回溯
            tempList.remove(tempList.size()-1);
        }

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

}
