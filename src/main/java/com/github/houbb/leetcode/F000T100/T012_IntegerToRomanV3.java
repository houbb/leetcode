package com.github.houbb.leetcode.F000T100;

/**
 * 阿拉伯数字转罗马字符-最佳策略
 *
 * @author binbin.hou
 * @date 2020-6-11 17:29:21
 * @since 1.0.0
 * @since best
 */
public class T012_IntegerToRomanV3 {

    public static void main(String[] args) {
        T012_IntegerToRomanV3 v3 = new T012_IntegerToRomanV3();
        v3.intToRoman(3);
    }

    int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] strings = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    /**
     * 利用减法替代除法+乘法
     *
     * @param num 数字
     * @return 结果
     * @since best
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            for(int i = 0; i < nums.length; i++) {
                int curNum = nums[i];
                if(num >= curNum) {
                    num -= curNum;
                    sb.append(strings[i]);
                    break;
                }
            }
        }

        return sb.toString();
    }

}
