package com.github.houbb.leetcode.topics.arrayTraverse;

public class T1089_DuplicateZero_V1_Force {

    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                // 当前位置后面的全部往后移动一个位置
                for(int j = n-1; j >= i+1; j--) {
                    arr[j] = arr[j-1];
                }
                // 下一个位置插入0
                i++;
                if(i >= n) {
                    return;
                }
                arr[i] = 0;
            }

            // 提前结束
            if(i >= n) {
                return;
            }
        }
    }

}
