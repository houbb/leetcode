package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T852_V5_TernarySearchRecursive {

    /**
     * 1) arr[m1] < arr[m2]
     *
     * 说明 peek 一定在 `[m1, r]`。
     *
     * 2) arr[m1] == arr[m2]
     *
     * 说明 peek 在 `[m1, m2]` 中间
     *
     * 1) arr[m1] > arr[m2]
     *
     * 说明  peek 一定在 `[l, m2]`。
     *
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        return peakIndexInMountainArrayRecursive(arr, 1, arr.length-1);
    }

    public int peakIndexInMountainArrayRecursive(int[] arr, int left, int right) {
        if(right - left > 2) {
            // 3 分点
            int m1 = left + (right-left) / 3;
            int m2 = right - (right-left) / 3;

            if(arr[m1] < arr[m2]) {
                return peakIndexInMountainArrayRecursive(arr, m1, right);
            }
            if(arr[m1] == arr[m2]) {
                return peakIndexInMountainArrayRecursive(arr, m1, m2);
            }
            if(arr[m1] > arr[m2]) {
                return peakIndexInMountainArrayRecursive(arr, left, m2);
            }
        }

        // 最后终止后遍历，最大的值就是 peek
        // 终止点
        int maxIx = left;
        for(int i = left+1; i <= right; i++) {
            if(arr[i] > arr[maxIx]) {
                maxIx = i;
            }
        }

        return maxIx;
    }

}
