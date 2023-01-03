package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

/**
 * @author d
 * @since 1.0.0
 */
public class T111_MinimumDepthOfBinaryTreeDFS {

    /**
     * 最小的高度
     *
     * 1. 左右节点的高度
     *
     * 把树拆分为左右两个部分。
     *
     * 2. 获取最小的高度作为结果
     *
     * 这样会导致单边节点的结果错误：[2,null,3,null,4,null,5,null,6]
     *
     * 预期是5，这样直接计算是1.因为左边实际上没有子节点。
     *
     * ps: 这题设计的说实在的，令人特别困惑。
     *
     * 问题:但是这个算法的性能非常的差，只有 10%。
     *
     * @param root 根
     * @return 结果
     */
    public int minDepth(TreeNode root) {
        // 终止条件
        if(root == null) {
            return 0;
        }

        // 递归处理左右节点
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        // 可是，如果有一个子节点为 NULL。那么应该返回大的一边，因为 NULL 节点不认为是有效的结果
        // 这里只是改良了一下比较，性能从 10%=》75%?
        if(leftDepth == 0) {
            return 1 + rightDepth;
        }
        if(rightDepth == 0) {
            return 1 + leftDepth;
        }

        // 返回小的一边，作为最小的结果。
        return Math.min(leftDepth, rightDepth) + 1;
    }


}
