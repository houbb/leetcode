package com.github.houbb.leetcode.F000T100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T093_RestoreIpAddresses {

    /**
     * 接替思路：
     *
     * 【fast-fail】
     *
     * 小於3
     *
     *  ip 地址由 4 個數字組成，每一組數字可以按照如下的規則考慮：
     *
     *  1位：都可以 0-9
     *  2位：不能以0開頭，其他都可以
     *  3位：
     *  1 開頭，后2位都行
     *  2 開頭，第二位為 0-5，第三位都行。
     *
     * 【約束】
     *
     * 0 <= s.length <= 3000
     *
     * 【TAG】
     * 回溯
     *
     * Runtime: 1 ms, faster than 98.71% of Java online submissions for Restore IP Addresses.
     * Memory Usage: 37.7 MB, less than 95.13% of Java online submissions for Restore IP Addresses.
     *
     * @param s 字符串
     * @return 結果列表
     */
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 || s.length() > 12) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<String> result, List<String> tempList, String s, int k) {
        if (s.isEmpty() || k == 4) {
            // 剛好組成4個元素。
            if (s.isEmpty() && k == 4) {
                StringBuilder stringBuilder = new StringBuilder();

                for(int i = 0; i < 4; i++) {
                    stringBuilder.append(tempList.get(i)).append(".");
                }

                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                result.add(stringBuilder.toString());
            }

            // 直接結束當前循環
            return;
        }
        // 剪枝算法
        // 實際測試效果一般，直接固定為1，和3也可以。
        int min = getMin(s, tempList);
        int max = getMax(s, tempList);
        for (int i = min; i <= max && i <= s.length(); i++) { // Avoid leading 0
            String part = s.substring(0, i);
            if (Integer.parseInt(part) <= 255) {
                tempList.add(part);
                backtrack(result, tempList, s.substring(i), k + 1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    // 1111 最小值，只能是1
    private int getMin(String s, List<String> tempList) {
        //其他幾位，全部為3個
        int remainMax = (3-tempList.size()) * 3;

        int remain = s.length() - remainMax;

        return Math.max(remain, 1);
    }

    private int getMax(String s, List<String> tempList) {
        if(s.charAt(0) == '0') {
            return 1;
        }

        // 其他至少每一位一個數字
        int remainMin = 3-tempList.size();

        int max =  s.length() - remainMin;
        if(max > 3) {
            max = 3;
        }
        return max;
    }


    public static void main(String[] args) {
        T093_RestoreIpAddresses addresses = new T093_RestoreIpAddresses();

        System.out.println(addresses.restoreIpAddresses("19216811"));
        System.out.println(addresses.restoreIpAddresses("25525511135"));
        System.out.println(addresses.restoreIpAddresses("1111"));
    }

}
