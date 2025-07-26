package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T852_V1_ForceLoop {

    //
    public int peakIndexInMountainArray(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i-1]) {
                return i-1;
            }
        }

        return -1;
    }

}
