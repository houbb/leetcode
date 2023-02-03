package com.github.houbb.leetcode.F200T300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T207_CourseScheduleV2 {

    public static void main(String[] args) {
        T207_CourseScheduleV2 courseSchedule = new T207_CourseScheduleV2();

        int[][] prerequisites = {
                {1,4},
                {2,4},
                {3,1},
                {3,2}
        };
        boolean result = courseSchedule.canFinish(5, prerequisites);
        System.out.println(result);
    }



    /**
     * 思路：DFS
     *
     * 【三种状态】
     *
     * 对于图中的任意一个节点，它在搜索的过程中有三种状态，即：
     *
     * 「未搜索」：我们还没有搜索到这个节点；
     *
     * 「搜索中」：我们搜索过这个节点，但还没有回溯到该节点，即该节点还没有入栈，还有相邻的节点没有搜索完成）；
     *
     * 「已完成」：我们搜索过并且回溯过这个节点，即该节点已经入栈，并且所有该节点的相邻节点都出现在栈的更底部的位置，满足拓扑排序的要求。
     *
     * 【DFS流程】
     *
     * 通过上述的三种状态，我们就可以给出使用深度优先搜索得到拓扑排序的算法流程，在每一轮的搜索搜索开始时，我们任取一个「未搜索」的节点开始进行深度优先搜索。
     *
     * 我们将当前搜索的节点 u 标记为「搜索中」，遍历该节点的每一个相邻节点 v：
     *
     * 如果 v 为「未搜索」，那么我们开始搜索 v，待搜索完成回溯到 u；
     *
     * 如果 v 为「搜索中」，那么我们就找到了图中的一个环，因此是不存在拓扑排序的；
     *
     * 如果 v 为「已完成」，那么说明 v 已经在栈中了，而 u 还不在栈中，因此 u 无论何时入栈都不会影响到 (u,v) 之前的拓扑关系，以及不用进行任何操作。
     *
     * 当 u 的所有相邻节点都为「已完成」时，我们将 u 放入栈中，并将其标记为「已完成」。
     *
     * 在整个深度优先搜索的过程结束后，如果我们没有找到图中的环，那么栈中存储这所有的 n 个节点，从栈顶到栈底的顺序即为一种拓扑排序。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */

    // 是否合法
    private boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //1. 构建边，用 list 和 hashMap 一样。list 需要初始化一遍，避免越界。
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for(int[] ints : prerequisites) {
            List<Integer> list = edges.getOrDefault(ints[1], new ArrayList<>());
            list.add(ints[0]);
            edges.put(ints[1], list);
        }

        // 3 种状态标记
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!valid) {
                break;
            }

            // 未访问
            if(visited[i] == 0) {
                dfs(edges, visited, i);
            }
        }

        return valid;
    }

    private void dfs(Map<Integer, List<Integer>> edges,
                     int[] visited,
                     int i) {
        if(!valid) {
            return;
        }

        // 访问中
        visited[i] = 1;

        // 遍历所有的边
        for(int v : edges.getOrDefault(i, new ArrayList<>())) {
            // 如果未访问的，递归
            if(visited[v] == 0) {
                dfs(edges, visited, v);
            } else if(visited[v] == 1) {
                // 存在环
                valid = false;
            } else {
                // v 已经入栈，不需要关心。
            }
        }

        // 访问完成
        visited[i] = 2;
    }

}
