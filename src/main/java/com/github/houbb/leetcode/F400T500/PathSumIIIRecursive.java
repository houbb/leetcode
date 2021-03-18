package com.github.houbb.leetcode.F400T500;

import com.github.houbb.leetcode.component.TreeNode;

/**
 * 递归
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class PathSumIIIRecursive {

    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int result = countPath(root,sum);
        int a = pathSum(root.left,sum);
        int b = pathSum(root.right,sum);
        return result+a+b;
    }

    public int countPath(TreeNode root,int sum){
        if(root == null){
            return 0;
        }
        sum = sum - root.val;
        int result = sum == 0 ? 1:0;
        return result + countPath(root.left,sum) + countPath(root.right,sum);
    }

}
