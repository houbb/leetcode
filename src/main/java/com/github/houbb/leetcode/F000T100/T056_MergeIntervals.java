package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.util.MultiArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T056_MergeIntervals {

    /**
     * 思路：重叠的定义是什么？
     *
     * intervals[i].length == 2
     * 0 <= start_i <= end_i <= 10^4
     *
     * end_i >= start_i+1
     *  就可以合并成为新的数组：
     *
     * start_i, end_i+1
     *
     * （1）难点1
     * 数组的大小如何判断？
     *
     * 暂时不考虑，通过 List 替代，后续优化。
     * （2）
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) {
            return intervals;
        }

        //sorting
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        MultiArrays.show(intervals);

        List<int[]> tempList = new ArrayList<>(intervals.length);
        for(int i = 0; i < intervals.length; i++) {
            // 当前元素
            int min = intervals[i][0];
            int max = intervals[i][1];

            int[] current = new int[]{min, max};
            // 下一个元素的开头
            if(i < intervals.length-1) {
                int[] nextNums = intervals[i+1];

                while (hasOverlap(current, nextNums)) {
                    min = Math.min(current[0], nextNums[0]);
                    max = Math.max(current[1], nextNums[1]);

                    current = new int[]{min, max};

                    i++;
                    // 跳出的边界是？
                    if(i >= intervals.length-1) {
                        break;
                    }
                    // 下一次迭代
                    nextNums = intervals[i+1];
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

    /**
     * 是否有重叠？
     * -----
     *   --
     *
     * ----
     *    ---
     * @param one
     * @param two
     * @return 是否
     */
    private boolean hasOverlap(int[] one, int[] two) {
        //1. 第一个是否在第二个范围内（排序之后，只看第二个即可。）
//        int minOne = one[0];
//        int maxOne = one[1];
//        if(inRange(minOne, two)) {
//            return true;
//        }
//        if(inRange(maxOne, two)) {
//            return true;
//        }

        //2. 第二个是否在第一个范围内
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
        T056_MergeIntervals mergeIntervals = new T056_MergeIntervals();

//        int[][] one = {
//                {1,3},{2,6},{8,10},{15,18}
//        };
//        MultiArrays.show(mergeIntervals.merge(one));
//        System.out.println("--------------------");
//
//        int[][] two = {
//                {1,4},{4,5}
//        };
//        MultiArrays.show(mergeIntervals.merge(two));
//        System.out.println("--------------------");
//
//        int[][] three = {
//                {1,4},{0,4}
//        };
//        MultiArrays.show(mergeIntervals.merge(three));
//        System.out.println("--------------------");
//
//        int[][] four = {
//                {1,4},{2,3}
//        };
//        MultiArrays.show(mergeIntervals.merge(four));

        int[][] five = {
                {2,3},{4,5},{6,7},{8,9},{1,10}
        };
        MultiArrays.show(mergeIntervals.merge(five));
    }


}
