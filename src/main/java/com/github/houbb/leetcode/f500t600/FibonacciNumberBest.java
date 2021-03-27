package com.github.houbb.leetcode.f500t600;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class FibonacciNumberBest {

    public static int fib(int n) {
        int[] nums = new int[]{
                0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040
        };

        return nums[n];
    }

    public static void main(String[] args) {
        for(int i = 0; i <= 30; i++) {
            System.out.print(FibonacciNumberBest.fib(i) + ", ");
        }
    }

}
