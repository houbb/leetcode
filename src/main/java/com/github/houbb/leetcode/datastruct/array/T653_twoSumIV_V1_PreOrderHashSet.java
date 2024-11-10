package com.github.houbb.leetcode.datastruct.array;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T653_twoSumIV_V1_PreOrderHashSet {

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

        int[] resFlag = new int[]{1};
        resFlag[0] = 0;
        preOrderTravel(numSet, root, k, resFlag);

        return resFlag[0] != 0;
    }

    private void preOrderTravel(Set<Integer> numSet,
                                TreeNode root,
                                int k,
                                int[] resFlag) {
        if(root == null || resFlag[0] != 0) {
            return;
        }

        // 符合
        int value = root.val;
        if(numSet.contains(k - value)) {
            resFlag[0] = 1;
            return;
        }
        numSet.add(value);

        preOrderTravel(numSet, root.left, k, resFlag);

        preOrderTravel(numSet, root.right, k, resFlag);
    }


}
