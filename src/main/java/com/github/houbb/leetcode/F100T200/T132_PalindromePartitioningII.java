package com.github.houbb.leetcode.F100T200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T132_PalindromePartitioningII {

    /**
     * 最小砍几刀
     */
    private int minCut = Integer.MAX_VALUE;

    /**
     * 整体思路：
     *
     * 1. 和原来划分的算法保持一致
     *
     * 2. 不过添加一个全局变量，保持 min，然后进行剪枝、
     *
     * @param s
     * @return
     */
    public int minCut(String s) {
        // 本身就是，则直接返回0
        if(isPalindrome(s)) {
            return 0;
        }

        // 初始化为最大长度-1
        minCut = s.length() - 1;

        List<List<String>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), s, 0);

        // 最多是长度-1
        // 全部不同，然后拆分

        return minCut;
    }

    private void backtrack(List<List<String>> results,
                           List<String> tempList,
                           String s, int startIndex) {

        // 剪枝
        // 但是性能依然不够。 会在 25/36 超时
        if(tempList.size() > minCut) {
            return;
        }

        // 终止的条件
        // 元素的長度等於 s
        if(startIndex == s.length()) {
            results.add(new ArrayList<>(tempList));

            // 更新最小值
            int curTime = results.get(results.size()-1).size()  -1;
            if(curTime < minCut) {
                minCut = curTime;
            }
        } else {
            // 如何进行回溯处理呢？
            for(int i = 1; i <= s.length()-startIndex; i++) {
                int endIndex = startIndex + i;
                String subString = s.substring(startIndex, endIndex);

                if(isPalindrome(subString)) {
                    tempList.add(subString);
                    // 执行具体的逻辑
                    backtrack(results, tempList, s, endIndex);

                    // 回溯
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }


    private boolean isPalindrome(String s) {
        if(s.length() == 1) {
            return true;
        }

        char[] chars = s.toCharArray();
        int low = 0;
        int high = chars.length-1;
        while (low < high) {
            if(chars[low] != chars[high] ) {
                return false;
            }

            low++;
            high--;
        }

        return true;
    }

    public static void main(String[] args) {
        T132_PalindromePartitioningII pp = new T132_PalindromePartitioningII();

        System.out.println(pp.minCut("aab"));
//        System.out.println(pp.partition("aab"));
//        System.out.println(pp.partition("efe"));
    }

}
