package com.github.houbb.leetcode.util;

import java.util.Arrays;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class MultiArrays {

    public static void show(int[][] matrix) {
        System.out.println("ARR-S-------------");
        for(int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("ARR-E-------------");
    }
}
