package com.github.houbb.leetcode.F000T100;

/**
 * <p> project: leetcode-RomanToInteger </p>
 * <p> create on 2020/6/11 21:29 </p>
 *
 * @author binbin.hou
 * @since v1
 */
public class T013_RomanToInteger {

    /**
     * 数字范围 1-3999
     *
     * String[] thousands = new String[]{"M", "MM", "MMM"};
     * String[] hundreds = new String[]{"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
     * String[] tens = new String[]{"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
     * String[] ones = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
     *
     * @param s 字符串
     * @return 结果
     * @since v1
     */
    public int romanToInt(String s) {
        int num = 0;

        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int nextIndex = i+1;
            if('M' == currentChar) {
                num += 1000;
            } else if('C' == currentChar) {
                num += 100;

                // CD=400  C+D = 600;
                // CM == 900; C+M=1100
                if(nextIndex < s.length() && (s.charAt(nextIndex) == 'D' || s.charAt(nextIndex) == 'M')) {
                    num -= 200;
                }
            } else if('D' == currentChar) {
                num += 500;
            } else if('X' == currentChar) {
                num += 10;

                // XC=90 X+C=110
                // XL=40 X+L=60
                if(nextIndex < s.length() && (s.charAt(nextIndex) == 'C' || s.charAt(nextIndex) == 'L')) {
                    num -= 20;
                }
            } else if('L' == currentChar) {
                num += 50;
            } else if('I' == currentChar) {
                num += 1;
                if(nextIndex < s.length() && (s.charAt(nextIndex) == 'V' || s.charAt(nextIndex) == 'X')) {
                    num -= 2;
                }
            } else if('V' == currentChar) {
                num += 5;
            }
        }

        return num;
    }

}
