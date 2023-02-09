package com.github.houbb.leetcode.F000T100;

/**
 * 整数翻转
 *
 * 核心点：
 * 1. 考虑符号位
 * 2. 考虑越界
 * 3. 考虑结尾为 0
 *
 * <p> project: leetcode-ZigzagConversion </p>
 * <p> create on 2020/6/9 23:52 </p>
 *
 * @author binbin.hou
 * @since v1
 */
public class T007_ReverseInteger {


    /**
     * 粗暴思路：
     * 判断是否大于 0
     * 取绝对值
     * 转换为字符串翻转处理。
     *
     * Runtime: 5 ms, faster than 11.06% of Java online submissions for Reverse Integer.
     * Memory Usage: 38.8 MB, less than 7.78% of Java online submissions for Reverse Integer.
     *
     * @param x 数字
     * @return 结果
     * @since v1
     */
    public int reverse(int x) {
        int abs = Math.abs(x);

        String string = String.valueOf(abs);
        String reverse = new StringBuilder(string).reverse().toString();

        int absReverse;
        try {
            absReverse = Integer.parseInt(reverse);
        } catch (NumberFormatException e) {
            return 0;
        }

        if(x >= 0) {
            return absReverse;
        }

        return -absReverse;
    }

}
