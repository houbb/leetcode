package com.github.houbb.leetcode.topics.arrayTraverse;

public class T1089_DuplicateZero_V3_TwoPointer {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,7,6,0,2,0,7};
        duplicateZeros(arr);
        System.out.println(arr);
    }

    public static void duplicateZeros(int[] arr) {
        int n = arr.length;

        // 需要记录有多少个零需要复写，不然可能会越界。可能0刚好是最后一个位置
        int zeroCount = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                zeroCount++;
            }
        }

        // 从哪里开始写
        // 从后往前，最后一个位置开始
        int i = n-1;
        int posIx = n - zeroCount - 1;
        while (i >= 0) {

        }


    }

}
