package com.github.houbb.leetcode.datastruct.array;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class T653_twoSumIV_V4_levelOrderHashSet {

    /**
     * 前序遍历
     *
     * 数据=》
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        // 构建结果列表
        Set<Integer> numSet = new HashSet<>();

        // 队列 模拟
        int[] resFlag = new int[]{1};
        resFlag[0] = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        levelOrderTravel(numSet, queue, k, resFlag);

        return resFlag[0] != 0;
    }

    private void levelOrderTravel(Set<Integer> numSet,
                                  Queue<TreeNode> queue,
                                  int k,
                                  int[] resFlag) {
        while (!queue.isEmpty()) {
            // 取出
            TreeNode root = queue.poll();
            // 符合
            int value = root.val;
            if(numSet.contains(k - value)) {
                resFlag[0] = 1;
                return;
            }
            numSet.add(value);

            // 加入左右
            if(root.left != null) {
                queue.offer(root.left);
            }
            if(root.right != null) {
                queue.offer(root.right);
            }
        }
    }


}
