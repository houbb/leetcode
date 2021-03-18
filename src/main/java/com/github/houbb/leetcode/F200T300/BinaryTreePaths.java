package com.github.houbb.leetcode.F200T300;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<>();
        binaryTreePaths(results, new StringBuilder(), root);
        return results;
    }

    private void binaryTreePaths(List<String> results, StringBuilder builder, TreeNode root) {
        if(root == null) {
            return;
        }

        builder.append(root.val);

        // 叶子节点
        if(root.left == null && root.right == null) {
            results.add(builder.toString());
        }
        builder.append("->");

        // 左右子树
        binaryTreePaths(results, new StringBuilder(builder), root.left);
        binaryTreePaths(results, new StringBuilder(builder), root.right);
    }

}
