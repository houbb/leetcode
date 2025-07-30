package com.github.houbb.leetcode.topics.arrayTraverse;

import java.util.Arrays;

public class T1089_DuplicateZero_V3_TwoPointer {

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void duplicateZeros(int[] arr) {
        int n = arr.length;

        // 慢指针
        int i = 0;
        // 快指针，包含复写0的数据
        int j = 0;

        // 这个跳出写法，比我的优雅很多
        while (j < n) {
            if(arr[i] == 0) {
                j++;
            }
            i++;
            j++;
        }

        // 此时，位置实际上在预期的后面一位
        i--;
        j--;

        //2.从尾到头进行双指针赋值 i : i->slow   j : n->fast
        while (i >= 0) {
            // j最后一步可能执行了+2操作,在此确保j的坐标小于n
            if(j < n) {
                arr[j] = arr[i];
            }

            //判断是否需要复写0
            if(arr[i] == 0 && j > 0) {
                arr[--j] = 0;
            }

            // 同时左移
            i--;
            j--;
        }
    }

}
