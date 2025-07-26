package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T852_V3_BinarySearchRecursive {

    /**
     * 2.1 `arr[mid+1] > arr[mid]` 说明在顶的左边。因为是递增的方向
     *
     * 则需要去右边查找 left = mid+1
     *
     * 2.2 `arr[mid+1] < arr[mid]` 后面一个值小于前面，此时要么是 peek，或者是 peek 的右边。因为开始递减了。
     *
     * a. `arr[mid-1] < arr[mid]` 两边都小于 mid，说明是顶点，直接返回 mid，命中结果
     *
     * b. `arr[mid-1] > arr[mid]` 说明在右边递减的区域，则应该去左边
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length-2;

        return peakIndexInMountainArrayRecursive(arr, left, right);
    }

    private int peakIndexInMountainArrayRecursive(int[] arr, int left, int right) {
        // NOT-FOUND
        if(left > right) {
            return -1;
        }

        int mid = left + (right-left)/2;

        // 在顶的左边。因为是递增的方向
        if(arr[mid+1] > arr[mid]) {
            return peakIndexInMountainArrayRecursive(arr, mid+1, right);
        }

        // 后面一个值小于前面，此时要么是 peek，或者是 peek 的右边。因为开始递减了
        if(arr[mid+1] < arr[mid]) {
            // 两边都小于，顶峰
            if(arr[mid-1] < arr[mid]) {
                return mid;
            } else {
                //说明在右边递减的区域，则应该去左边
                return peakIndexInMountainArrayRecursive(arr, left, mid-1);
            }
        }

        // 不会到这里
        return -1;
    }

}
