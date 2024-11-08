package com.github.houbb.leetcode.F1000T1100;

import java.util.*;

public class T1182_MIN_COLOR_V2 {

        public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
            // 预处理
            Map<Integer, List<Integer>> colorMap = new HashMap<>();
            for (int i = 0; i < colors.length; i++) {
                int color = colors[i];
                List<Integer> indexList = colorMap.getOrDefault(color, new ArrayList<>());
                indexList.add(color);
                colorMap.put(color, indexList);
            }
            List<Integer> resultList = new ArrayList<>(Collections.nCopies(queries.length, -1));
            // 遍历每个查询
            for (int i = 0; i < queries.length; i++) {
                int index = queries[i][0];
                int targetColor = queries[i][1];

                // 如果当前位置的颜色就是目标颜色，距离为0
                if (colors[index] == targetColor) {
                    resultList.set(i, 0);
                    continue;
                }
                // 获取目标颜色的索引列表
                List<Integer> indexList = colorMap.get(targetColor);
                if (indexList == null) {
                    // 如果没有该颜色，返回 -1
                    resultList.set(i, -1);
                    continue;
                }

                // 使用二分查找查找最近的索引
                int left = -1, right = -1;
                int pos = Collections.binarySearch(indexList, index);
                // 如果目标位置已经存在，直接返回 0
                if (pos >= 0) {
                    resultList.set(i, 0);
                    continue;
                }

                // 如果目标位置不存在，binarySearch 会返回负值，我们需要调整该值来获取插入位置
                // pos  return -(low + 1);  // key not found
                pos = -pos - 1;
                // 查找右边的最近位置
                if (pos < indexList.size()) {
                    right = indexList.get(pos) - index;
                }
                // 查找左边的最近位置
                if (pos > 0) {
                    left = index - indexList.get(pos - 1);
                }
                // 计算最小的距离
                int minDistance = Integer.MAX_VALUE;
                if (right >= 0) {
                    minDistance = Math.min(minDistance, right);
                }
                if (left >= 0) {
                    minDistance = Math.min(minDistance, left);
                }

                // 如果没有找到有效的距离，则返回 -1
                resultList.set(i, minDistance == Integer.MAX_VALUE ? -1 : minDistance);
            }

            return resultList;
        }

        public static void main(String[] args) {
            T1182_MIN_COLOR_V2 solution = new T1182_MIN_COLOR_V2();
            int[] colors = {1, 1, 2, 1, 3, 2, 2, 3, 3};
            int[][] queries = {{1, 3}, {2, 2}, {6, 1}};
            System.out.println(solution.shortestDistanceColor(colors, queries));  // 输出: [3, 0, 3]

            int[] colors2 = {1, 2};
            int[][] queries2 = {{0, 3}};
            System.out.println(solution.shortestDistanceColor(colors2, queries2));  // 输出: [-1]
        }


}
