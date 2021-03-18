package com.github.houbb.leetcode.F400T500;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class PathSumIIIBest {


    // key是前缀和, value是大小为key的前缀和出现的次数
    Map<Integer, Integer> prefixMap;
    int target;

    public int pathSum(TreeNode root, int sum) {
        prefixMap = new HashMap<>();
        target = sum;

        // 前缀和为0的一条路径
        prefixMap.put(0, 1);
        return recur(root, 0);
    }

    private int recur(TreeNode node, int curSum) {
        // 1.递归终止条件
        if(node == null) {
            return 0;
        }

        // 2.本层要做的事情
        int res = 0;
        // 当前路径上的和
        curSum += node.val;

        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        res += prefixMap.getOrDefault(curSum - target, 0);
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);

        // 3.进入下一层
        int left = recur(node.left, curSum);
        int right = recur(node.right, curSum);

        res = res + left + right;

        // 4.回到本层，恢复状态，去除当前节点的前缀和数量
        prefixMap.put(curSum, prefixMap.get(curSum) - 1);

        return res;
    }

}
