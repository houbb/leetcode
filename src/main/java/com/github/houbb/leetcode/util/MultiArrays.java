package com.github.houbb.leetcode.util;

import java.util.Arrays;
import java.util.List;

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

    public static void show(char[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }


    public static void show(List<int[]> matrix) {
        System.out.println("ARR-S-------------");
        for(int i = 0; i < matrix.size(); i++) {
            System.out.println(Arrays.toString(matrix.get(i)));
        }
        System.out.println("ARR-E-------------");
    }
}
