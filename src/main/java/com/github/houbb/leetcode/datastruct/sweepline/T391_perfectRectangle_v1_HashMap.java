package com.github.houbb.leetcode.datastruct.sweepline;

import java.util.*;

public class T391_perfectRectangle_v1_HashMap {

    /**
     * 思路：
     *
     * 1. 所有的重合点移除-通过 HashMap 实现
     * 2. 所有的面积之和等于最后的正方形面积。
     *
     * 给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。
     *
     * 那么对应的 4 个点为：
     * (xi, bi) (ai, bi)
     * (xi, yi) (ai, yi)
     *
     * @param rectangles
     * @return
     */
    public boolean isRectangleCover(int[][] rectangles) {
        Map<String, Integer> pointMap = new HashMap<>();

        int area = 0;
        for(int[] ints : rectangles) {
            String one = ints[0]+","+ints[1];
            String two = ints[2]+","+ints[3];
            String three = ints[0]+","+ints[3];
            String four = ints[2]+","+ints[1];

            pointMap.put(one, (pointMap.getOrDefault(one, 0) + 1) % 2);
            pointMap.put(two, (pointMap.getOrDefault(two, 0) + 1) % 2);
            pointMap.put(three, (pointMap.getOrDefault(three, 0) + 1) % 2);
            pointMap.put(four, (pointMap.getOrDefault(four, 0) + 1) % 2);

            int currentArea = (ints[2]-ints[0]) * (ints[3] - ints[1]);
            area += currentArea;
        }

        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();

        for(Map.Entry<String,Integer> entry : pointMap.entrySet()) {
            String key = entry.getKey();
            Integer count = entry.getValue();
            if(count == 1) {
                String[] splits = key.split(",");
                int x = Integer.parseInt(splits[0]);
                int y = Integer.parseInt(splits[1]);

                xList.add(x);
                yList.add(y);
            }
        }

        // 应该有4个点
        if(xList.size() != 4 || yList.size() != 4) {
            return false;
        }

        // 面积计算
        Collections.sort(xList);
        Collections.sort(yList);
        int fourPointArea = (xList.get(3) - xList.get(0)) * (yList.get(3) - yList.get(0));

        if(fourPointArea == area) {
            return true;
        }
        return false;
    }

}
