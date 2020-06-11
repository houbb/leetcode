package com.github.houbb.leetcode;

import java.util.*;

/**
 * 方格之间保留水的面积最大。
 *
 * 1. 水墙壁的宽度忽略，相邻2个间距为下标的差。
 * 2. 不可以倾斜。
 * 3. n 至少为 2
 * 4.考虑水的流动性，高度只能等于最短的。
 *
 * 图中有一个不合理的地方（或者中间挡板是可以让水通过的），可以考虑把中间挡板直接移除。
 *
 * 简单思路：遍历穷举
 * 进阶思路：DP
 *
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-11 14:57:39
 */
public class ContainerWithMostWater {

    /**
     * 双指针法
     *
     * 【思路】
     *
     * 首先从 l=0, r=height.length-1（两边）
     *
     * （1）比较二者数字大小
     *
     * if(height[l] < height[r]) {
     *      // 左边小，那么高度被固定，右边移动已经达到最大。只能左边向右移动
     * } else {
     *     // 右边下，右边高度被固定，只能最右往左移动。
     * }
     *
     * （2）终止条件
     * l >= R 则终止。
     *
     * （3）优化点
     *
     * 因为每次只移动一位，所以不需要每次都采用减法，直接使用变量保存即可。
     * 大小比较实用内部方法，而不是 Math 的方法。
     *
     * 【效果】
     *
     * Runtime: 2 ms, faster than 95.28% of Java online submissions for Container With Most Water.
     * Memory Usage: 40 MB, less than 38.16% of Java online submissions for Container With Most Water.
     * @param height 高度列表
     * @return 结果
     * @since best
     */
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int maxArea = 0;
        int width = height.length-1;

        while (l < r) {
            int area = min(height[l], height[r]) * (width);
            maxArea = max(area, maxArea);

            // 考虑如何移动指针
            if(height[l] >= height[r]) {
                // 左边比较大
                r--;
            } else {
                l++;
            }
            width--;
        }
        return maxArea;
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * 计算最大面积
     *
     * 优化思路：重复计算的跳过。
     *
     * Runtime: 843 ms, faster than 5.04% of Java online submissions for Container With Most Water.
     * Memory Usage: 39.4 MB, less than 94.66% of Java online submissions for Container With Most Water.
     *
     * @param height 高度
     * @return 结果
     * @since v1
     */
    public int maxAreaBasic(int[] height) {
        int maxResult = -1;
        for(int i = 0; i < height.length; i++) {
            for(int j = 0; j < height.length; j++) {
                // 跳过自身相等的元素
                if(i == j) {
                    continue;
                }

                int hi = height[i];
                int hj = height[j];
                int min = Math.min(hi, hj);
                int x = Math.abs(j - i);
                int area = x * min;

                if(area > maxResult) {
                    maxResult = area;
                }
            }
        }

        return maxResult;
    }

    /**
     * 优化思路
     *
     * 1. 避免重复计算
     * 2. j 永远大于 i，跳过计算
     * @param height 高度数组
     * @return 结果
     * @since v2
     */
    public int maxAreaV2(int[] height) {
        int maxResult = -1;
        for(int i = 0; i < height.length; i++) {
            for(int j = i+1; j < height.length; j++) {
                int hi = height[i];
                int hj = height[j];
                int min = Math.min(hi, hj);
                int x = j-i;
                int area = x * min;

                if(area > maxResult) {
                    maxResult = area;
                }
            }
        }

        return maxResult;
    }

    /**
     * 优化思路
     *
     * 1. 排序
     * 避免高度比较
     *
     * 2. 需要记录下原始的位置。
     *
     * 3. 元素去重。
     *
     * 【性能】
     * 这个太慢了，效果很差。
     * @param height 高度数组
     * @return 结果
     * @since v3
     */
    @Deprecated
    public int maxAreaV3(int[] height) {
        // 保留原始下标
        Map<Integer, List<Integer>> indexMap = new LinkedHashMap<>(height.length);
        for(int i = 0; i < height.length; i++) {
            int heightVal = height[i];
            List<Integer> list = indexMap.get(heightVal);

            if(list == null) {
                list = new ArrayList<>();
            }
            // 放在列表后，这个列表的下标是天然从小到达的。
            list.add(i);
            indexMap.put(heightVal, list);
        }

        // 统一排序
        for(Map.Entry<Integer, List<Integer>> entry : indexMap.entrySet()) {
            Collections.sort(entry.getValue());
        }

        int maxResult = -1;
        // 变化为不同高度的对比
        List<Integer> heightList = new ArrayList<>(indexMap.keySet());
        for(int i = 0; i < heightList.size()-1; i++) {
            for(int j = i+1; j < heightList.size(); j++) {
                // 最左边一个元素
                int leftY = heightList.get(i);
                int leftX = indexMap.get(leftY).get(0);

                // 最后一个
                int rightY = heightList.get(j);
                List<Integer> indexList = indexMap.get(rightY);
                int rightX = indexList.get(indexList.size()-1);

                int area = Math.abs(rightX-leftX) * Math.min(leftY, rightY);
                if(area > maxResult) {
                    maxResult = area;
                }
            }
        }

        // 相同高度的差异
        for(Map.Entry<Integer, List<Integer>> entry : indexMap.entrySet()) {
            List<Integer> sameXs = entry.getValue();
            if(sameXs.size() < 2) {
                continue;
            }

            int sameY = entry.getKey();
            int area = sameY * (sameXs.get(sameXs.size()-1) - sameXs.get(0));
            if(area > maxResult) {
                maxResult = area;
            }
        }


        return maxResult;
    }


}
