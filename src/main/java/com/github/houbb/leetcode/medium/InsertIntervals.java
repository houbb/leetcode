package com.github.houbb.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class InsertIntervals {

    /**
     * 【优化思路】
     * <p>
     * 因为已经排序了，所以不需要再次排序。
     * <p>
     * 但是需要遍历，找到需要处理的位置。
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 避免扩容
        List<int[]> result = new ArrayList<>(intervals.length + 1);

        int i = 0;
        for (i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
                continue;
            }

            //  intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
            //  找到第一个可以插入的位置
            if (intervals[i][0] <= newInterval[0] || intervals[i][0] <= newInterval[1]) {
                // 合并为最小值
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);

                // 向后合并，如果，直到下一个元素的开始大于当前插入元素的结尾
                while (i < intervals.length && intervals[i][0] <= newInterval[1])
                    i++;
                // 合并为最大值
                newInterval[1] = Math.max(intervals[i - 1][1], newInterval[1]);
            }
            break;
        }
        result.add(newInterval);

        // 补全后面的部分
        for (i = i; i < intervals.length; i++)
            result.add(intervals[i]);

        int[][] output = new int[result.size()][2];
        for (i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }
        return output;
    }


}
