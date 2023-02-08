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
    public int reverseBasic(int x) {
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

    /**
     * 使用栈，然后计算每一位的值。
     * 最后逆序输出即可。
     *
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Integer.
     * Memory Usage: 36.4 MB, less than 94.78% of Java online submissions for Reverse Integer.
     * Next challenges:
     *
     * @param x 元素
     * @return 结果
     * @since v2
     */
    public int reverse(int x) {
        long result = 0;

        while (x != 0) {
            // 移除最后一位
            int pop = x % 10;
            x = x / 10;

            // 返回值
            result = result * 10 + pop;
        }

        // 越界判断
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

}
