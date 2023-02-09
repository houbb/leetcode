package com.github.houbb.leetcode.F000T100;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T009_PalindromeNumberV2 {

    /**
     * 最佳解法
     *
     * 【效果】
     *
     * @param x 数字
     * @return 结果
     * @since best
     */
    public boolean isPalindrome(int x) {
        int temp = x;
        int ds = 0;
        while (temp > 0) {
            // 直接反向操作，计算逆序的数值
            ds = ds * 10 + (temp % 10);

            // 保留的高位
            temp /= 10;
        }

        return (x - ds) == 0;
    }

}
