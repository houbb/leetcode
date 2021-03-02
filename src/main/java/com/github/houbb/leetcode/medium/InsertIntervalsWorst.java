package com.github.houbb.leetcode.medium;

import com.github.houbb.leetcode.util.MultiArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class InsertIntervalsWorst {

    /**
     * 思路：重叠的定义是什么？
     *
     *
     * 这种是偷懒的写法，性能比较差。
     * （1）寻找插入的位置
     *
     * 二分法
     *
     * （2）其他不变
     *
     * @param intervals
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            return new int[][]{newInterval};
        }
        if(newInterval.length == 0) {
            return intervals;
        }

        //找到插入的位置
        List<int[]> list = new ArrayList<>(intervals.length+1);
        list.addAll(Arrays.asList(intervals));
        list.add(newInterval);

        // 排序（如果找到合适的插入位置，可以省去排序）
        list.sort(Comparator.comparingInt(o -> o[0]));

        List<int[]> tempList = new ArrayList<>(list.size());
        for(int i = 0; i < list.size(); i++) {
            // 当前元素
            int min = list.get(i)[0];
            int max = list.get(i)[1];

            int[] current = new int[]{min, max};
            // 下一个元素的开头
            if(i < list.size()-1) {
                int[] nextNums = list.get(i+1);

                while (hasOverlap(current, nextNums)) {
                    min = Math.min(current[0], nextNums[0]);
                    max = Math.max(current[1], nextNums[1]);

                    current = new int[]{min, max};

                    i++;
                    // 跳出的边界是？
                    if(i >= list.size()-1) {
                        break;
                    }
                    // 下一次迭代
                    nextNums = list.get(i+1);
                }
            }

            tempList.add(new int[]{min, max});
        }


        // 存放到数组中
        // 但是这个很傻，很消耗性能
        // 如何优化这个数组拷贝呢？
        int[][] results = new int[tempList.size()][2];
        for(int i = 0; i < tempList.size(); i++) {
            results[i] = tempList.get(i);
        }
        return results;
    }

    private boolean hasOverlap(int[] one, int[] two) {
        int minTwo = two[0];
        int maxTwo = two[1];
        if(inRange(minTwo, one)) {
            return true;
        }
        if(inRange(maxTwo, one)) {
            return true;
        }

        return false;
    }

    private boolean inRange(int num, int[] nums) {
        if(nums[0] <= num && nums[1] >= num) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        InsertIntervalsWorst mergeIntervals = new InsertIntervalsWorst();
        int[][] five = {
                {1,3}, {6,9}
        };
        int[] newArray = {
                2, 5
        };
        MultiArrays.show(mergeIntervals.insert(five, newArray));
    }


}
