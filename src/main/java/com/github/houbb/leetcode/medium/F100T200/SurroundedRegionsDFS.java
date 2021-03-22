package com.github.houbb.leetcode.medium.F100T200;

import com.github.houbb.leetcode.util.MultiArrays;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class SurroundedRegionsDFS {


    private int m;
    private int n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        if(m <= 2 || n <= 2) {
            return;
        }

        // 第一行和最后一行
        for(int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m-1, i);
        }
        // 第一列和最后一列
        for(int i = 1; i < m-1; i++) {
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }

        // 统一处理
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return;
        }

        // 标记
        board[i][j] = '#';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }

    public static void main(String[] args) {
        SurroundedRegionsDFS surroundedRegionsDFS = new SurroundedRegionsDFS();
        //[["O","X","X","O","X"],
        // ["X","O","O","X","O"],
        // ["X","O","X","O","X"],
        // ["O","X","O","O","O"],
        // ["X","X","O","X","O"]]
        char[][] chars =  {
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'},
        };

        surroundedRegionsDFS.solve(chars);

        MultiArrays.show(chars);
    }


}
