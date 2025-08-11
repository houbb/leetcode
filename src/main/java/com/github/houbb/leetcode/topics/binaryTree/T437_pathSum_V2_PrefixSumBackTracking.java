package com.github.houbb.leetcode.topics.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class T437_pathSum_V2_PrefixSumBackTracking {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        // 标记着从 直接从起点累积到目标这种 CASE
        prefixSumCount.put(0L, 1);

        return dfs(root, 0, targetSum, prefixSumCount);
    }

    public int dfs(TreeNode root, long curSum, long targetSum, Map<Long, Integer> prefixSumCount) {
        if(root == null) {
            return 0;
        }

        // 更新
        curSum += root.val;

        // 从 map 中查找对应的值
        int res = prefixSumCount.getOrDefault(curSum - targetSum, 0);

        // 更新前缀和: 说明符合这个数据的路径+1
        prefixSumCount.put(curSum, prefixSumCount.getOrDefault(curSum, 0) + 1);

        // 累加左+右
        res += dfs(root.left, curSum, targetSum, prefixSumCount);
        res += dfs(root.right, curSum, targetSum, prefixSumCount);

        // 回溯 curSum 这个总数-1
        prefixSumCount.put(curSum, prefixSumCount.get(curSum)-1);

        return res;
    }

}
