package com.github.houbb.leetcode.medium;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class BinaryTreePreorderTraversalLoop {

    /**
     *
     * 【思路】
     *
     * 数据=》左=》右
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
     * Memory Usage: 36.9 MB, less than 95.24% of Java online submissions for Binary Tree Preorder Traversal.
     *
     */
    public List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> rights = new Stack<>();

        while(node != null) {
            list.add(node.val);
            System.out.println("\n【根节点】添加值：" + node.val +", 列表：" + list);

            if (node.right != null) {
                rights.push(node.right);
                System.out.println("【右节点-入】node.right="+node.right + " 入栈，stack: " +rights);
            }

            node = node.left;
            System.out.println("【左节点】继续访问 node.left = " + node);
            if (node == null && !rights.isEmpty()) {
                node = rights.pop();

                System.out.println("【右节点-出】弹出访问右节点。" + node + " 出栈， stack: " + rights);
            }
        }
        return list;
    }

}
