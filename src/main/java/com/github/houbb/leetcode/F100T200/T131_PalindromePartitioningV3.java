package com.github.houbb.leetcode.F100T200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T131_PalindromePartitioningV3 {

    /**
     * 思路：通过 backtrack 本身并没有问题。
     *
     * 但是性能这一块其实可以通过 dp 优化，通过内存记录上一次的数据，然后减少计算。
     * @param s 字符串
     * @return 结果
     */
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();

        // 初始化 dp 数组
        boolean[][] dp = new boolean[s.length()][s.length()];
        String[][] mem = new String[s.length()+1][s.length()+1];

        // 初始化
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;

                    // 提前存储字符串
                    mem[j][i] = s.substring(j, i+1);
                }
            }
        }

        backtrack(mem, results, new ArrayList<>(), s, 0);
        return results;
    }

    private void backtrack(String[][] mem,
                           List<List<String>> results,
                           List<String> tempList,
                           String s,
                           int startIndex) {
        // 终止的条件
        // 元素的長度等於 s
        if(startIndex == s.length()) {
            results.add(new ArrayList<>(tempList));
        } else {
            // 判断就会变得相对简单

            for(int i = startIndex; i < s.length(); i++) {
                // 是，则说明为回文
                String subString = mem[startIndex][i];
                if(subString != null) {
                    tempList.add(subString);

                    // 执行具体的逻辑
                    backtrack(mem, results, tempList, s, i+1);

                    // 回溯
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        T131_PalindromePartitioningV3 pp = new T131_PalindromePartitioningV3();

        //Input: s = "aab"
        //Output: [["a","a","b"],["aa","b"]]
        System.out.println(pp.partition("aab"));
//        System.out.println(pp.partition("aab"));
//        System.out.println(pp.partition("efe"));
    }

}
