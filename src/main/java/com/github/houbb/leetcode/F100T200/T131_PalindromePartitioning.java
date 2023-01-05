package com.github.houbb.leetcode.F100T200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T131_PalindromePartitioning {

    /**
     * Runtime: 8 ms, faster than 79.54% of Java online submissions for Palindrome Partitioning.
     * Memory Usage: 52.8 MB, less than 67.93% of Java online submissions for Palindrome Partitioning.
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), s, 0);
        return results;
    }

    private void backtrack(List<List<String>> results, List<String> tempList,
                           String s, int startIndex) {
        // 终止的条件
        // 元素的長度等於 s
        if(startIndex == s.length()) {
            results.add(new ArrayList<>(tempList));
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
        T131_PalindromePartitioning pp = new T131_PalindromePartitioning();

        System.out.println(pp.partition("abbab"));
//        System.out.println(pp.partition("aab"));
//        System.out.println(pp.partition("efe"));
    }

}
