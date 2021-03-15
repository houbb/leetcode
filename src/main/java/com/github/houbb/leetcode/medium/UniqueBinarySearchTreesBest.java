package com.github.houbb.leetcode.medium;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class UniqueBinarySearchTreesBest {

    public int numTrees(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long c = 1;

        // 当然，针对 2 的乘法，还可以使用位运算进行优化。
        for (int i = 0; i < n; ++i) {
            c = c * 2 * (2 * i + 1) / (i + 2);
        }

        return (int) c;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesBest trees = new UniqueBinarySearchTreesBest();

        System.out.println(trees.numTrees(3));
    }

}
