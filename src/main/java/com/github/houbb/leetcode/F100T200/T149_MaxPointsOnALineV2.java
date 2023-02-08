package com.github.houbb.leetcode.F100T200;

import java.math.BigDecimal;
import java.util.*;

public class T149_MaxPointsOnALineV2 {

    public static void main(String[] args) {
        //[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]
        int[][] points = {
                {1,1},
                {3,2},
                {5,3},
                {4,1},
                {2,3},
                {1,4},
        };

        Map<BigDecimal, List<Integer>> map = new HashMap<>();
        map.put(BigDecimal.valueOf(-1), Arrays.asList(1,3,4,5));

//        new T148_MaxPointsOnALineV2().getMaxPoint(map.entrySet().iterator().next(), points);
        System.out.println(new T149_MaxPointsOnALineV2().maxPoints(points));;
    }

    /**
     * 1. 通过斜率做一个简单的归类
     * 2. 相同的斜率，在进行处理
     *
     * @param points 点
     * @return 结果
     */
    public int maxPoints(int[][] points) {
        int len = points.length;
        if(len <= 2) {
            return len;
        }

        // 如果 value 用 int，计算出来的知识点的组合。
        // 我们应该存放的是点本身，不考虑直线。避免斜率错乱
        // 这里其实只保留了相同斜率的点，是否在同一个直线上，需要进一步过滤。
        Map<java.math.BigDecimal, List<Integer>> kMap = new HashMap<>();

        // 垂直的直线
        Map<Integer, List<Integer>> virtualKMap = new HashMap<>();

        // 遍历2-2比较，穷举
        for(int i = 0; i < len-1; i++) {
            for(int j = i+1; j < len; j++) {
                // 避免点重复，我们约束 j > i;
                if(j <= i) {
                    continue;
                }

                int[] first = points[i];
                int[] second = points[j];

                // 如果是一条垂直直线
                if(first[0] == second[0]) {
                    int x = first[0];
                    List<Integer> pointSet = virtualKMap.getOrDefault(x, new ArrayList<>());
                    addPoint(pointSet, i, j);
                    virtualKMap.put(x, pointSet);
                } else {
                    // 计算斜率
                    java.math.BigDecimal k = calcK(first, second);
                    List<Integer> pointSet = kMap.getOrDefault(k, new ArrayList<>());
                    addPoint(pointSet, i, j);
                    kMap.put(k, pointSet);
                }
            }
        }

        // 遍历找到最大的
        int maxCount = 0;
        for(Map.Entry<java.math.BigDecimal, List<Integer>> entry : kMap.entrySet()) {
            // 处理判断是否在同一个直线上
            int maxPoint = getMaxPoint(entry, points);
            if(maxPoint > maxCount) {
                maxCount = maxPoint;
            }
        }
        for(Map.Entry<Integer, List<Integer>> entry : virtualKMap.entrySet()) {
            List<Integer> set = entry.getValue();
            if(set.size() > maxCount) {
                maxCount = set.size();
            }
        }
        return maxCount;
    }

    private void addPoint(List<Integer> pointSet,
                          Integer first,
                          Integer second) {
        if(!pointSet.contains(first)) {
            pointSet.add(first);
        }

        if(!pointSet.contains(second)) {
            pointSet.add(second);
        }
    }

    /**
     * 是否在一条直线上
     * @param entry 斜率 entry
     * @param points 所有的点
     * @return 结果
     */
    private int getMaxPoint(Map.Entry<java.math.BigDecimal, List<Integer>> entry,
                          int[][] points) {
        List<Integer> set = entry.getValue();

        // 先不考虑性能，避免点重复
        // 最少为2
        int maxCount = 2;
        for(int i = 0; i < set.size()-2; i++) {
            // 固定2个点
            int firstIndex = set.get(i);
            int secondIndex = set.get(i+1);
            int[] fixFirst = points[firstIndex];
            int[] fixSecond = points[secondIndex];

            // 判断其余的点是否经过这条直线，首先包含当前点
            List<Integer> fitList = new ArrayList<>();
            fitList.add(i);
            fitList.add(i+1);

            for(int j = i+2; j < set.size(); j++) {
                // 判断是否合适
                int curIndex = set.get(j);
                if(isFit(fixFirst, fixSecond, points[curIndex])) {
                    fitList.add(curIndex);
                }
            }

            if(fitList.size() > maxCount) {
                maxCount = fitList.size();
            }
        }

        return maxCount;
    }

    /**
     * 是否在一条直线上
     *
     * 【可能存在误差】
     * 点斜式：已知直线l的斜率是k，并且经过点P1(x1，y1)
     * 直线方程是y-y1=k(x-x1)
     *
     * 但要注意两个特例：
     *
     * a当直线的斜率为0°时直线的方程是y=y1；
     * b当直线的斜率为90°时，直线的斜率不存在，直线方程是x=x1；
     *
     * 【两点式】
     *
     * 两点式：已知直线l上的两点P1(x1，y1)、P2(x2，y2)，(x1≠x2)
     * 直线方程是(y-y1)/(y2-y1)=(x-x1)/(x2-x1)
     *
     * 把这个替换为乘法，避免精度丢失。也有可能导致计算越界。
     * 越界的话，可以使用 java.math.BigDecimal 替代。
     * (y-y1) * (x2-x1) = (y2-y1) * (x - x1)
     *
     * @param fixFist 固定点 1
     * @param fixSecond 固定点 2
     * @param otherPoint 待验证的点
     * @return 结果
     */
    private boolean isFit(int[] fixFist,
                          int[] fixSecond,
                          int[] otherPoint) {
        //(y-y1) * (x2-x1) = (x - x1) * (y2-y1)
        int valueLeft = (otherPoint[1] - fixFist[1]) * (fixSecond[0] - fixFist[0]);
        int valueRight = (otherPoint[0] - fixFist[0]) * (fixSecond[1] - fixFist[1]);
        return valueLeft == valueRight;
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
        return y.divide(x, 32, java.math.RoundingMode.HALF_DOWN);
    }

}
