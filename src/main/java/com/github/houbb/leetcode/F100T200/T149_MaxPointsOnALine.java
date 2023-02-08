package com.github.houbb.leetcode.F100T200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 有问题的？
 */
public class T149_MaxPointsOnALine {

    public static void main(String[] args) {
        //[0,0],[4,5],[7,8],[8,9],[5,6],[3,4],[1,1]
        int[][] points = new int[7][2];
        points[0] = new int[]{0,0};
        points[1] = new int[]{4,5};
        points[2] = new int[]{7,8};
        points[3] = new int[]{8,9};
        points[4] = new int[]{5,6};
        points[5] = new int[]{3,4};
        points[6] = new int[]{1,1};

        new T149_MaxPointsOnALine().maxPoints(points);
    }

    /**
     * Input: points = [[1,1],[2,2],[3,3]]
     * Output: 3
     *
     * 是否在一个直线上，主要看 2 个点之间的斜率。
     *
     * k = (y2-y1) / (x2 - x1)
     *
     * 我们可以把任意两点的斜率计算出来，把斜率 k 当做 key,出现的次数当做 value。
     *
     *
     *
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        int len = points.length;
        if(len <= 1) {
            return len;
        }

        // 如果 value 用 int，计算出来的知识点的组合。
        // 我们应该存放的是点本身，不考虑直线。避免斜率错乱
        Map<java.math.BigDecimal, Set<String>> kMap = new HashMap<>();

        // 垂直的直线
        Map<Integer, Set<String>> virtualKMap = new HashMap<>();

        // 遍历2-2比较，穷举
        for(int i = 0; i < len-1; i++) {
            for(int j = i+1; j < len; j++) {
                // 避免点重复，我们约束 j > i;
                if(j <= i) {
                    continue;
                }

                int[] first = points[i];
                int[] second = points[j];
                String pointFirst = first[0]+":"+first[1];
                String pointSecond = second[0]+":"+second[1];

                // 如果是一条垂直直线
                if(first[0] == second[0]) {
                    int x = first[0];
                    Set<String> pointSet = virtualKMap.getOrDefault(x, new HashSet<>());
                    pointSet.add(pointFirst);
                    pointSet.add(pointSecond);
                    virtualKMap.put(x, pointSet);
                } else {
                    // 计算斜率
                    java.math.BigDecimal k = calcK(first, second);
                    Set<String> pointSet = kMap.getOrDefault(k, new HashSet<>());
                    pointSet.add(pointFirst);
                    pointSet.add(pointSecond);
                    kMap.put(k, pointSet);
                }
            }
        }

        System.out.println(kMap);
        System.out.println(virtualKMap);

        // 遍历找到最大的
        int maxCount = 0;
        for(Map.Entry<java.math.BigDecimal, Set<String>> entry : kMap.entrySet()) {
            Set<String> set = entry.getValue();

            if(set.size() > maxCount) {
                maxCount = set.size();
            }
        }
        for(Map.Entry<Integer, Set<String>> entry : virtualKMap.entrySet()) {
            Set<String> set = entry.getValue();
            if(set.size() > maxCount) {
                maxCount = set.size();
            }
        }
        return maxCount;
    }

    /**
     * 计算斜率
     *
     * k = (y2-y1) / (x2-x1)
     *
     * 如果 x2 = x1，那么斜率等于？？？？
     * @param first
     * @param second
     * @return
     */
    private java.math.BigDecimal calcK(int[] first,
                             int[] second) {
        int x1 = first[0];
        int y1 = first[1];

        int x2 = second[0];
        int y2 = second[1];

        // 这里边存在一个问题，可能是两条不同的直线，但是斜率相同。
        if(x1 == x2) {
            return java.math.BigDecimal.valueOf(Long.MAX_VALUE);
        }

        java.math.BigDecimal y = java.math.BigDecimal.valueOf(y2-y1);
        java.math.BigDecimal x = java.math.BigDecimal.valueOf(x2-x1);
        // 精度丢失？
        return y.divide(x, 10, java.math.RoundingMode.HALF_DOWN);
    }

}
