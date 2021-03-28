package com.github.houbb.leetcode.medium;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class BinaryTreeInorderTraversalLoop {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     * Memory Usage: 37 MB, less than 88.15% of Java online submissions for Binary Tree Inorder Traversal.
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(current !=null || !stack.empty()){
            // 寻找到最左边的节点
            while(current !=null){
                stack.add(current);

                System.out.println("【入栈】当前节点" + current +", STACK: " + stack);
                System.out.println("【左子树】继续访问 " +current.val +" 左子树: " + current.left);
                current = current.left;
            }

            // pop 处理
            current = stack.pop();
            System.out.println("【出栈】当前节点: " + current +", STACK: " + stack);
            list.add(current.val);
            System.out.println("【添加】添加节点" + current.val +", LIST: " + list);
            System.out.println("【右子树】访问节点" + current.val +" 右子树" + current.right + "\n");
            current = current.right;
        }

        return list;
    }

}
