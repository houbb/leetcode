package com.github.houbb.leetcode.medium.F100T200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * dp[i,j] = min(dp[i-1, j], dp[i-1, j-1]) + c[i][j];
 * @author binbin.hou
 * @since 1.0.0
 */
public class TriangleDp {

    /**
     * 还是动态规划？
     * 最笨的方法：
     *
     * dp[i] = Math.min(dp[i-1], dp[i-1]') ;
     *
     * 两条路：
     * （1）下一步相同
     * （2）下一步 index+1
     *
     *
     * Runtime: 1 ms, faster than 96.81% of Java online submissions for Triangle.
     * Memory Usage: 38.8 MB, less than 92.94% of Java online submissions for Triangle.
     *
     * @param triangle 三角形
     * @return 结果
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];

        // 初始化
        dp[0][0] = triangle.get(0).get(0);

        // 遍历（i 对应层级）
        for(int i = 1; i < size; i++) {
            //1. 如果为 0，上一层也只能为 0
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);

            //2. 中间部分
            for(int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
            }

            //3. 如果为 i
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }

        // 遍历获取最小的一个
        int minTotal = dp[size - 1][0];
        for (int i = 1; i < size; i++) {
            minTotal = Math.min(minTotal, dp[size - 1][i]);
        }
        return minTotal;
    }


    public static void main(String[] args) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(Arrays.asList(2));
        results.add(Arrays.asList(3, 4));
        results.add(Arrays.asList(6,5, 7));
        results.add(Arrays.asList(4,1, 8, 4));

        TriangleDp triangle = new TriangleDp();
        System.out.println(triangle.minimumTotal(results));
    }

}
