package com.github.houbb.leetcode.medium;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.*;

/**
 * 後續遍歷
 * @author binbin.hou
 * @since 1.0.0
 */
public class BinaryTreePostorderTraversalLoopDebug {

    /**
     *
     * 【思路】
     *
     * 左=》右=>D
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Postorder Traversal.
     * Memory Usage: 37 MB, less than 95.15% of Java online submissions for Binary Tree Postorder Traversal.
     */
    public List<Integer> postorderTraversal(TreeNode root){
        LinkedList<Integer> lists = new LinkedList<>();
        if(root == null){
            return lists;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        System.out.println("【根节点】root.value="+root.val+" 入栈，STACK " + root);

        TreeNode current = null;
        while(!stack.isEmpty()){
            current = stack.pop();
            lists.addFirst(current.val);
            System.out.println("\n【出栈】"+current.val+"，STACK " + lists);
            System.out.println("【添加】添加 "+current.val+" 到 LIST" + lists);

            if(current.left != null){
                stack.push(current.left);
                System.out.println("【左节点】入栈 "+current.left.val+" 到 STACK " + stack);
            }
            if(current.right != null){
                stack.push(current.right);
                System.out.println("【右节点】入栈 "+current.right.val+" 到 STACK " + stack);
            }
        }
        return lists;
    }

}
