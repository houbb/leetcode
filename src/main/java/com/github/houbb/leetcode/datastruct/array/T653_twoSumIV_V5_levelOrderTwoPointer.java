package com.github.houbb.leetcode.datastruct.array;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.*;

public class T653_twoSumIV_V5_levelOrderTwoPointer {

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
        List<Integer> sortList = new ArrayList<>();

        // 中序获取排序数组
        inOrderTravel(sortList, root);

        // 双指针
        return twoSum(sortList, k);
    }

    public boolean twoSum(List<Integer> sortList, int target) {
        int n = sortList.size();
        int left = 0;
        int right = n-1;

        while (left < right) {
            int sum = sortList.get(left) + sortList.get(right);
            if(sum == target) {
                return true;
            }
            if(sum < target) {
                left++;
            }
            if(sum > target) {
                right--;
            }
        }

        return false;
    }


    private void inOrderTravel(List<Integer> sortList,
                               TreeNode root) {
        if(root == null) {
            return;
        }
        inOrderTravel(sortList, root.left);

        // add
        sortList.add(root.val);

        inOrderTravel(sortList, root.right);
    }


}
