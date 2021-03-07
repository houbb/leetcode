package com.github.houbb.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class PermutationSequence {

    /**
     * 解題思路
     *
     * 這一題本質上还是一道回溯的题目。
     *
     * 但是需要额外的技巧。
     *
     * https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        List<List<Integer>> all = new ArrayList<>();

        List<Integer> tempList = new ArrayList<>();
        backtrack(all, tempList, n, k, 1);

        // 返回列表中的最后一个。
        List<Integer> integers = all.get(k-1);
        StringBuilder stringBuilder = new StringBuilder();
        for(Integer i : integers) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }

    // 如何可以簡化這個操作呢？
    // 其實我們只關心第 K 個元素
    private void backtrack(List<List<Integer>> all, List<Integer> tempList,
                           int n, int k, int start) {
        if(tempList.size() == n) {
            // 满了
            all.add(new ArrayList<>(tempList));

            // 如果大小已经够了，直接剪枝
            if(all.size() >= k) {
                return;
            }
        }

        for(int i = 1; i <= n; i++) {
            // 跳过重复的元素
            if(tempList.contains(i)) {
                continue;
            }

            tempList.add(i);
            // 下一个元素
            backtrack(all, tempList, n, k, start+1);
            // 移除，回溯
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        PermutationSequence ps = new PermutationSequence();
        System.out.println(ps.getPermutation(3, 3));
        System.out.println(ps.getPermutation(4, 9));
        System.out.println(ps.getPermutation(3, 1));
        // 594738216
        System.out.println(ps.getPermutation(9, 199269));
    }

}
