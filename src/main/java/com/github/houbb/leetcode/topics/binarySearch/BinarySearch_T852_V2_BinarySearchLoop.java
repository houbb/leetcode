package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T852_V2_BinarySearchLoop {

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

        while (left <= right) {
            int mid = left + (right-left)/2;

            // 在顶的左边。因为是递增的方向
            if(arr[mid+1] > arr[mid]) {
                left= mid+1;
            }

            // 后面一个值小于前面，此时要么是 peek，或者是 peek 的右边。因为开始递减了
            if(arr[mid+1] < arr[mid]) {
                // 两边都小于，顶峰
                if(arr[mid-1] < arr[mid]) {
                    return mid;
                } else {
                    //说明在右边递减的区域，则应该去左边
                    right = mid-1;
                }
            }
        }
        return -1;
    }

}
