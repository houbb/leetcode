package com.github.houbb.leetcode.F100T200;

import java.util.LinkedList;
import java.util.Queue;

public class T200_NumberOfIslandsV2 {


    private class Pair {
        private int i;
        private int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    /**
     * BFS
     *
     * 1. 遍历，找到第一个 1
     * 2. 上下左右遍历，把经过的位置置为 0
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int[] offsets = {0, 1, 0, -1, 0};

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;


        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';

                    //queue
                    Queue<Pair> queue = new LinkedList<>();
                    queue.add(new Pair(i, j));

                    while (!queue.isEmpty()) {
                        Pair pair = queue.remove();

                        // 四个方向
                        for (int k = 0; k < 4; k++) {
                            int x = pair.i + offsets[k], y = pair.j + offsets[k + 1];
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                                grid[x][y] = '0';
                                queue.add(new Pair(x, y));
                            }
                        }
                    }
                }
            }
        }

        return count;
    }

}
