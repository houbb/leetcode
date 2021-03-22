package com.github.houbb.leetcode.medium.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class SumRootToLeafNumsBetter {


    private int sum = 0;
    private int temp = 0;

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum Root to Leaf Numbers.
     * Memory Usage: 36.2 MB, less than 96.95% of Java online submissions for Sum Root to Leaf Numbers.
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        calc(root);
        return sum;
    }

    private void calc(TreeNode node) {
        if(node == null) {
            return;
        }

        temp = temp * 10 + node.val;
        // 叶子
        if(node.left == null && node.right == null) {
            sum += temp;
        }

        // 递归子节点
        calc(node.left);
        calc(node.right);

        // 返回上一层
        temp /= 10;
    }

}
