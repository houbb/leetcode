//package com.github.houbb.leetcode.medium;
//
//import com.sun.scenario.effect.impl.prism.PrImage;
//
//import java.util.Arrays;
//import java.util.Random;
//
///**
// * 思路：有序的数组，可以直接根据二分查询，找到对应的 index
// * <p>
// * 然后随机生产一个一个平移的数字，对数组进行平移。
// *
// * @author binbin.hou
// * @since 1.0.0
// */
//@Deprecated
//public class SearchInRotatedSortedArray {
//
//    /**
//     * Input: nums = [4,5,6,7,0,1,2], target = 0
//     * Output: 4
//     * @param nums
//     * @param target
//     * @return
//     */
//    public int search(int[] nums, int target) {
////        int index = binarySearch(nums, target);
//
//        // 没有旋转，或者全部旋转
//        int randomK = getRandomK(nums);
//        if(-1 == randomK) {
//            return binarySearch(nums, target);
//        }
//
//        // 将数组拆成2个部分
//        int[] lefts = getLefts(nums, randomK);
//        int[] rights = getRights(nums, randomK);
//
//        int leftIndex = binarySearch(lefts, target);
//        if(leftIndex != -1) {
//            return leftIndex;
//        }
//
//        // 右边寻找
//        int rightIndex = binarySearch(rights, target);
//        if(rightIndex != -1) {
//            // 0==>
//            return rightIndex + randomK + 1;
//        }
//
//
//        // 如果不存在
//        return -1;
//    }
//
//    private int[] getLefts(int[] nums, int randomK) {
//        int size = randomK+1;
//        int result[] = new int[size];
//
//        for(int i = 0; i < size; i++) {
//            result[i] = nums[i];
//        }
//        return result;
//    }
//
//    private int[] getRights(int[] nums, int randomK) {
//        int size = nums.length-1-randomK;
//        int[] result = new int[size];
//
//        for(int i = 0; i < size; i++) {
//            result[i] = nums[i+randomK+1];
//        }
//        return result;
//    }
//
//    /**
//     * 获取随机数
//     *
//     * 寻找 k > k+i 的位置
//     *
//     * [4,5,6,7,0,1,2]
//     * @param nums 数组
//     * @return 变化的长度
//     * @since v33
//     */
//    private int getRandomK(final int[] nums) {
//        for(int i = 0; i < nums.length-1; i++) {
//            if(nums[i] > nums[i+1]) {
//                return i;
//            }
//        }
//
//        // 根据顺序找到即可
//        return -1;
//    }
//
//
//
//    /**
//     * 二分查询
//     * <p>
//     * 备注：ASC
//     *
//     * @param nums   原始数组
//     * @param target 目标值
//     * @return 结果
//     * @since v33
//     */
//    private static int binarySearch(int[] nums, int target) {
//        int low = 0;
//        int high = nums.length - 1;
//        while (low <= high) {
//            int mid = (high+low)/2;
//            int midVal = nums[mid];
//
//            // 刚好相等
//            if (target == midVal) {
//                return mid;
//            } else if (target > midVal) {
//                // 当前信息偏小
//                low = mid+1;
//            } else {
//                // 数据偏大
//                high = mid-1;
//            }
//        }
//
//        //NOT FOUND
//        return -1;
//    }
//
//    public static void main(String[] args) {
//        // 4,5,6,7,0,1,2
//        int[] arrays = new int[]{4,5,6,7,0,1,2};
//
////        offsetArray(arrays, 3);
//        int[] nums = {-1, 0,1,2};
//        System.out.println(binarySearch(nums, 0));
////        int[] nums2 = {-1,0,1,2,3};
////        System.out.println(binarySearch(nums2, 1));
////        int result = new SearchInRotatedSortedArray().search(arrays, 3);
////        System.out.println(result);
//    }
//
//
//    /**
//     * 如何处理好旋转？？
//     *
//     *  [0,1,2,4,5,6,7] + 3 ==》 [4,5,6,7,0,1,2].
//     *
//     *  [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
//     *
//     *  两种解题方式：
//     *
//     *  （1）当前两个数组处理
//     *  （2）还原数组处理
//     *
//     * @param nums
//     * @param k
//     */
//    @Deprecated
//    private static void offsetArray(int nums[], int k) {
//        int len = nums.length;
//        if(len == 1 || k == len-1 || k == 0) {
//            return;
//        }
//
//        // 什么是旋转呢？
//        // 使用临时数组 保存前 K 个内容
//        int[] numTemp = new int[k];
//        int tempSize = 0;
//        // 首先临时保存 后面 k 个 的内容
//        for(int i = len-k; i < len; i++) {
//            numTemp[tempSize++] = nums[i];
//        }
//
//        // 从后向前平移
//        for(int i = len-k-1; i >= 0; i--) {
//            nums[i+k] = nums[i];
//        }
//
//        // 将临时的信息设置到最后面
//        for(int i = 0; i < k; i++) {
//            nums[i] = numTemp[i];
//        }
//    }
//
//
//}
