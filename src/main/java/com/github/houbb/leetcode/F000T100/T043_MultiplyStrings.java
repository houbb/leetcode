package com.github.houbb.leetcode.F000T100;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T043_MultiplyStrings {

    /**
     *
     * 问题1：乘法的本质是什么？
     *
     * 12
     * 12
     * ----
     * 144 ??
     *
     * 权重：
     * 12 * 2 + 12 * 10
     *
     * = 10 * 2 + 2*2 + 10*10 + 2*10
     *
     * = 144
     *
     * 实际上就是对应的每一位，都进行相乘运算，把超过 10 的部分进行进位处理。
     *
     * 【优化思路】
     * 1. 通过比较，避免除法+取模
     * 2. 通过 chars，避免字符串的 charAt
     *
     * @author github.com/houbb
     * @param num1 数字1
     * @param num2 数字2
     * @return 结果
     */
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        // 2*2 对应的 index = 0 1 2，所以需要减一个
        int lenOne = num1.length();
        int lenTwo = num2.length();
        int[] results = new int[lenOne + lenTwo-1];

        // 直接使用数组，避免边界 charAt 判断
        char[] charsOne = num1.toCharArray();
        char[] charsTwo = num2.toCharArray();
        // 计算乘积
        for(int i = 0; i < lenOne; i++) {
            for(int j = 0; j < lenTwo; j++) {
                results[i+j] += (charsOne[i] - '0') * (charsTwo[j] - '0');
            }
        }

        // 处理进位
        // 从后向前（最高位在前面）
        for(int i = results.length - 1; i > 0; i--) {
            // 进位优化
            if(results[i] >= 10) {
                // 进位的部分
                results[i-1] += results[i]/10;
                // 只保留个位数
                results[i] = results[i] % 10;
            }
        }

        // 拼接字符串
        // 应该从数组的最后开始
        // 最高位为 0 的处理？  10 * 10 = 100;
        StringBuilder stringBuilder = new StringBuilder();
        for (int result : results) {
            stringBuilder.append(result);
        }

        // 乘法的逻辑
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        T043_MultiplyStrings multiplyStrings = new T043_MultiplyStrings();
        System.out.println(multiplyStrings.multiply("12", "12"));
        System.out.println(multiplyStrings.multiply("99", "99"));
    }

}
