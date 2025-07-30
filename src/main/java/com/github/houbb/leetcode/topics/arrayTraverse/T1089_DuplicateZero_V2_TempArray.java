package com.github.houbb.leetcode.topics.arrayTraverse;

public class T1089_DuplicateZero_V2_TempArray {

    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = 0;

        // 临时数组
        int[] temp = new int[n];
        for(right = 0; right < n; right++) {
            temp[left++] = arr[right];
            // 提前结束
            if(left >= n) {
                break;
            }

            // 处理0
            if(arr[right] == 0) {
                temp[left++] = 0;
                if(left >= n) {
                    break;
                }
            }
        }

        // copy
        System.arraycopy(temp, 0, arr, 0, n);
    }

}
