package com.github.houbb.leetcode.medium.F100T200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class TriangleDpOptimize {

    /**
     * 还是动态规划？
     *
     * Runtime: 1 ms, faster than 96.81% of Java online submissions for Triangle.
     * Memory Usage: 39.4 MB, less than 25.02% of Java online submissions for Triangle.
     *
     * @param triangle 三角形
     * @return 结果
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        // 最后一行，初始化到 dp
        int[] dp = new int[size];
        for(int i = 0; i < size; i++) {
            dp[i] = triangle.get(size-1).get(i);
        }

        for(int i = size-2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }


    public static void main(String[] args) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(Arrays.asList(2));
        results.add(Arrays.asList(3, 4));
        results.add(Arrays.asList(6,5, 7));
        results.add(Arrays.asList(4,1, 8, 4));

        TriangleDpOptimize triangle = new TriangleDpOptimize();
        System.out.println(triangle.minimumTotal(results));
    }

}
