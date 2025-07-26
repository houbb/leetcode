package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T852_V4_TernarySearchLoop {

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
        int left = 1;
        int right = arr.length-2;

        // 差值不少于2
        while (right - left > 2) {
            // 3 分点
            int m1 = left + (right-left) / 3;
            int m2 = right - (right-left) / 3;

            if(arr[m1] < arr[m2]) {
                left = m1;
            }
            if(arr[m1] == arr[m2]) {
                left = m1;
                right = m2;
            }
            if(arr[m1] > arr[m2]) {
                right = m2;
            }
        }

        // 最后终止后遍历，最大的值就是 peek
        int maxIx = left;
        for(int i = left+1; i <= right; i++) {
            if(arr[i] > arr[maxIx]) {
                maxIx = i;
            }
        }

        return maxIx;
    }


}
