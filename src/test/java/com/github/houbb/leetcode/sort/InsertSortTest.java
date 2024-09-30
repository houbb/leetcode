package com.github.houbb.leetcode.sort;

import java.util.ArrayList;
import java.util.List;

public class InsertSortTest {


    /**
     * 插入排序
     * @param nums
     * @return
     */
    public static List<Integer> insertSort(int[] nums) {
        List<Integer> resultList = new ArrayList<>(nums.length);
        // 第一个元素。默认有序
        resultList.add(nums[0]);

        // 从数组中的第二个元素开始
        for(int i = 1; i < nums.length; i++) {
            // 从后向前遍历，把大于当前元素的信息全部向后移动。
            int position = getInsertPosition(resultList, nums[i]);
            resultList.add(position, nums[i]);
        }

        return resultList;
    }

    //O(n) 的插入寻找算法
    private static int getInsertPosition(List<Integer> resultList, int target) {
        for(int i = 0; i < resultList.size(); i++) {
            int current = resultList.get(i);
            if(target >= current) {
                return i;
            }
        }

        // 插入到最后
        return resultList.size();
    }

    public static void main(String[] args) {
        System.out.println(InsertSortTest.insertSort(new int[]{3,5,2}));
        System.out.println(InsertSortTest.insertSort(new int[]{2,3,5,2}));
        System.out.println(InsertSortTest.insertSort(new int[]{8,3,5,2}));
        System.out.println(InsertSortTest.insertSort(new int[]{8,9,5,2}));
    }

}
