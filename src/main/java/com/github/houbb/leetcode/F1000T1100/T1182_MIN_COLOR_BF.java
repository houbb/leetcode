package com.github.houbb.leetcode.F1000T1100;

import java.util.*;

public class T1182_MIN_COLOR_BF {

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> ans = new ArrayList<>();

        // 对于每个查询
        for (int[] query : queries) {
            int index = query[0];    // 查询的索引
            int targetColor = query[1];  // 目标颜色

            // 初始化最短距离为 -1
            int minDistance = -1;

            // 遍历整个 colors 数组，寻找目标颜色
            for (int i = 0; i < colors.length; i++) {
                if (colors[i] == targetColor) {
                    // 如果目标颜色在当前位置找到，计算当前索引和目标位置的距离
                    int distance = Math.abs(i - index);
                    // 如果最短距离未设置或者当前距离更短，则更新最短距离
                    if (minDistance == -1 || distance < minDistance) {
                        minDistance = distance;
                    }
                }
            }

            // 将最短距离添加到答案列表中
            ans.add(minDistance);
        }

        return ans;
    }

    public static void main(String[] args) {
        T1182_MIN_COLOR_BF solution = new T1182_MIN_COLOR_BF();

        // 测试用例1
        int[] colors = {1, 1, 2, 1, 3, 2, 2, 3, 3};
        int[][] queries = {{1, 3}, {2, 2}, {6, 1}};
        System.out.println(solution.shortestDistanceColor(colors, queries));  // 输出: [3, 0, 3]

        // 测试用例2
        int[] colors2 = {1, 2};
        int[][] queries2 = {{0, 3}};
        System.out.println(solution.shortestDistanceColor(colors2, queries2));  // 输出: [-1]
    }


}
