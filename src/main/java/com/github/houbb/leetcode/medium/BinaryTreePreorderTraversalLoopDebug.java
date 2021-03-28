package com.github.houbb.leetcode.medium;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class BinaryTreePreorderTraversalLoopDebug {

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
    //根据前序遍历的特点，我们很容易将其与栈的特点相结合
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> lists = new ArrayList<>();
        if(root == null){
            return lists;
        }

        Stack<TreeNode> stack = new Stack<>();
        //根节点先入栈
        stack.push(root);
        System.out.println("【根节点】root.value="+root.val+" 入栈，STACK " + root);

        TreeNode current = null;
        while(!stack.isEmpty()){
            current = stack.pop();
            lists.add(current.val);
            System.out.println("\n【出栈】"+current.val+"，STACK " + lists);
            System.out.println("【添加】添加 "+current.val+" 到 LIST" + lists);
            //这里注意，要先压入右子结点，再压入左节点。因为栈是先进后出
            if(current.right != null){
                stack.push(current.right);
                System.out.println("【右节点】入栈 "+current.right.val+" 到 STACK " + stack);
            }
            if(current.left != null){
                stack.push(current.left);
                System.out.println("【左节点】入栈 "+current.left.val+" 到 STACK " + stack);
            }
        }
        return lists;
    }

}
