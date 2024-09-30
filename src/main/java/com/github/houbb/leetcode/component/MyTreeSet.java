package com.github.houbb.leetcode.component;

import java.util.ArrayList;
import java.util.List;

public class MyTreeSet {

    public static void main(String[] args) {
        MyTreeSet myTreeSet = new MyTreeSet();
        myTreeSet.add(1L);
        myTreeSet.add(5L);
        myTreeSet.add(9L);

        System.out.println("--------------DONE");

        System.out.println(myTreeSet.ceiling(1L));
    }

    private ArrayList<Long> list;

    public MyTreeSet() {
        list = new ArrayList<>();
    }

    public void add(Long value) {
        // 首先检查元素是否已存在
        if (!contains(value)) {
            int index = getInsertPosition(list, value);
            list.add(index, value);
        }
    }

    public boolean remove(Long value) {
        if (contains(value)) {
            int index = binarySearch(value);
            list.remove(index);
            return true;
        }
        return false;
    }

    public Long ceiling(Long value) {
        return findCeiling(list, value);
    }

    private boolean contains(Long value) {
        return binarySearch(value) >= 0;
    }

    private int binarySearch(Long value) {
        int low = 0;
        int high = list.size()-1;

        while (low <= high) {
            int mid = (low+high) / 2;

            Long midVal = list.get(mid);
            if(midVal.equals(value)) {
                return mid;
            } else if(midVal.compareTo(value) < 0) {
                // 小于指定元素
                low = mid+1;
            } else {
                // 大于指定元素
                high = mid-1;
            }
        }

        return -1;
    }

    private static int getInsertPosition(List<Long> resultList, long target) {
        int left = 0;
        int right = resultList.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target <= resultList.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // left 就是插入的索引位置
        return left;
    }

    public static Long findCeiling(List<Long> nums, Long target) {
        if (nums == null || nums.isEmpty()) {
            return null;
        }

        int left = 0;
        int right = nums.size() - 1;
        Long result = null;

        while (left <= right) {
            int mid = (left + right) / 2;
            Long midVal = nums.get((int) mid);

            if (midVal >= target) {
                result = midVal;
                right = mid - 1; // 尝试在左侧查找更小的值
            } else {
                left = mid + 1; // 否则在右侧查找
            }
        }

        // 检查结果是否满足大于等于target的条件
        if (result != null && result >= target) {
            return result;
        }
        return null;
    }

    public int size() {
        return list.size();
    }

    public void printList() {
        System.out.println(list);
    }

}
