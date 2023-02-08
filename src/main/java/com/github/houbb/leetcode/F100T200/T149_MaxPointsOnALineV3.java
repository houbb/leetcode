package com.github.houbb.leetcode.F100T200;

import java.math.BigDecimal;
import java.util.*;

public class T149_MaxPointsOnALineV3 {

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
        System.out.println(new T149_MaxPointsOnALineV3().maxPoints(points));;
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

        Map<String, List<Integer>> kMap = new HashMap<>();
        Map<Integer, List<Integer>> virtualKMap = new HashMap<>();

        for(int i = 0; i < len-2; i++) {
            // 第一个点
            int[] first = points[i];
            // 遍历第二个点
            for(int j = i+1; j < len-1; j++) {
                if(i == j) {
                    continue;
                }
                // 第二个点
                int[] second = points[j];
                final String key = i+":"+j;

                // 如果是一条垂直直线
                if(first[0] == second[0]) {
                    int x = first[0];
                    List<Integer> pointSet = virtualKMap.getOrDefault(x, new ArrayList<>());
                    addPoint(pointSet, i, j);
                    virtualKMap.put(x, pointSet);
                } else {
                    // 首先把2个点放进去
                    List<Integer> pointSet = new ArrayList<>();
                    addPoint(pointSet, i, j);
                    kMap.put(key, pointSet);
                }

                // 待确定的第三个点
                for(int k = j+1; k < len; k++) {
                    if(k == i
                        || k == j) {
                        continue;
                    }

                    // 待验证的点
                    int[] otherPoint = points[k];

                    // 如果 x1=x2，只看横坐标即可
                    if(first[0] == second[0]
                            && first[0] == otherPoint[0]) {
                        int x = first[0];
                        List<Integer> pointSet = virtualKMap.get(x);
                        addPoint(pointSet, k);
                        virtualKMap.put(x, pointSet);
                    } else if(isFit(first, second, otherPoint)) {

                        List<Integer> pointSet = kMap.get(key);
                        addPoint(pointSet, k);
                        kMap.put(key, pointSet);
                    }
                }
            }
        }

        // 遍历找到最大的
        int maxCount = 2;
        for(Map.Entry<String, List<Integer>> entry : kMap.entrySet()) {
            if(entry.getValue().size() > maxCount) {
                maxCount = entry.getValue().size();
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
                          Integer... points) {
        for(Integer integer : points) {
            if(!pointSet.contains(integer)) {
                pointSet.add(integer);
            }
        }
    }

    /**
     * 是否在一条直线上
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

}
