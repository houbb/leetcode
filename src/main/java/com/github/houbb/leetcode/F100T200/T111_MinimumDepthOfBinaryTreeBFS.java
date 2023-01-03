package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author d
 * @since 1.0.0
 */
public class T111_MinimumDepthOfBinaryTreeBFS {

    /**
     * BFS: 广度优先遍历
     *
     * https://leetcode.com/problems/minimum-depth-of-binary-tree/solutions/36045/my-4-line-java-solution/
     * https://leetcode.com/problems/minimum-depth-of-binary-tree/solutions/2710825/java-breadth-first-linear-time-extra-memory-grows-with-number-of-nodes/
     *
     * @param root 根
     * @return 结果
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int layerSize = queue.size();
            while (layerSize > 0) {
                TreeNode tempNode = queue.poll();
                if (tempNode.left == null && tempNode.right == null) {
                    return depth + 1;
                }
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
                layerSize--;
            }
            depth++;
        }
        return depth;
    }


}
