package com.github.houbb.leetcode.F200T300;

/**
 * 是否存在重复元素
 *
 * @since 20231117
 */
public class T217_ContainsDuplicateV4CompareTest {

    public static int[] buildTestNums() {
        int size = 100000;
        int[] nums = new int[size+1];
        int ix = 0;
        for(int i = size; i >= 0; i--) {
            nums[ix++] = i;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = buildTestNums();
        int[] nums2 = buildTestNums();

        // 原始解法1
        long start1 = System.currentTimeMillis();
        T217_ContainsDuplicateV3InsertSort insertSort = new T217_ContainsDuplicateV3InsertSort();
        insertSort.containsDuplicate(nums);
        long end1 = System.currentTimeMillis();
        System.out.println("1=" + (end1-start1));

        // 原始解法2
        long start2 = System.currentTimeMillis();
        T217_ContainsDuplicateV4InsertSortOptimize optimize = new T217_ContainsDuplicateV4InsertSortOptimize();
        optimize.containsDuplicate(nums2);
        long end2 = System.currentTimeMillis();
        System.out.println("2=" + (end2-start2));

        // 原始解法3
        long start3 = System.currentTimeMillis();
        T217_ContainsDuplicate first = new T217_ContainsDuplicate();
        first.containsDuplicate(nums2);
        long end3 = System.currentTimeMillis();
        System.out.println("3=" + (end3-start3));
    }

}
