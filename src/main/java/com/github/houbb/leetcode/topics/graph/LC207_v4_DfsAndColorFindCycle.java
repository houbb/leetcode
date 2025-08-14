package com.github.houbb.leetcode.topics.graph;

import java.util.*;

public class LC207_v4_DfsAndColorFindCycle {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> preMap = new HashMap<>();

        // 初始化
        for(int[] ints : prerequisites) {
            int cur = ints[0];
            int pre = ints[1];

            // 谁依赖了我
            Set<Integer> preSet = preMap.getOrDefault(pre, new HashSet<>());
            preSet.add(cur);
            preMap.put(pre, preSet);
        }

        // 颜色
        int[] colors = new int[numCourses];

        // zero
        for(int i = 0; i < numCourses; i++) {
           if(colors[i] == 0 && dfsDetectCycle(i, preMap, colors)) {
                return false;
           }
        }
        return true;
    }

    public boolean dfsDetectCycle(int i, Map<Integer, Set<Integer>> preMap, int[] colors) {
        // 正在访问
        colors[i] = 1;
        // 从当前位置可以到达的所有点
        if(preMap.containsKey(i)) {
            for (int y : preMap.get(i)) {

                // DFS 时遇到 colors[y] == 1，说明我们沿着路径又回到了一个正在访问的节点 → 形成环。
                if (colors[y] == 1 || (colors[y] == 0 && dfsDetectCycle(y, preMap, colors))) {
                    return true;
                }
            }
        }


        // 访问完成
        colors[i] = 2;
        return false;
    }


}
