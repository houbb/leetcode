package com.github.houbb.leetcode.F100T200;

import java.util.ArrayList;
import java.util.List;

public class T125_ValidPalindrome {

    /**
     * 如何保证 O(1)？
     *
     * 1. 直接遍历一遍，然后把大写=》小写、
     * 2. 移除非 字母、数字的信息
     * 3. 最后判断结果，是否为从前往后，从后往前一样？
     *
     * @param s 字符串
     * @return 是否
     */
    public boolean isPalindrome(String s) {
        //1. 处理结果
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 是否为数字，字母
            if(Character.isLetterOrDigit(c)) {
                list.add(Character.toLowerCase(c));
            }
        }

        // 处理
        return isReverse(list);
    }

    /**
     * 是否翻转是如何对比的？
     *
     * 从前往后遍历，和重后往前遍历。其实只需要对比一半就行。
     * @param list 列表
     * @return 结果
     */
    private boolean isReverse(List<Character> list) {
        if(list.isEmpty()) {
            return true;
        }

        int mid = list.size() / 2;

        for(int i = 0; i <= mid; i++) {
            Character preC = list.get(i);
            Character reverseC = list.get(list.size()-i-1);

            if(!preC.equals(reverseC)) {
                return false;
            }
        }

        return true;
    }

}
