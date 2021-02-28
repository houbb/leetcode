package com.github.houbb.leetcode.medium;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class PowerxN {

    /**
     * x^7 = x * x^6;
     * x^6 = x^3 * x3;
     *
     * 注意：
     * （1）负数
     * （2）{@link Integer#MIN_VALUE} 最小值问题
     *
     * @param x 底数
     * @param n 次幂
     * @return 结果
     */
    public double myPow(double x, int n) {
        // 如果这个数是0，实际上 0 次幂没有意义
        if (n == 0) {
            return 1;
        }

        // 需要避免最小值问题
        // 最小值的 -2147483648，相反数并不是 Integer.MAX 所以这里转换一下。
        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }

        // 注意 overflow
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        // 递归
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return x * myPow(x * x, n / 2);
        }

    }

    public static void main(String[] args) {
        PowerxN powerxN = new PowerxN();

        System.out.println(Integer.MIN_VALUE);

        System.out.println(powerxN.myPow(1.00000,
                2147483647));
        System.out.println(powerxN.myPow(2, 10));
        System.out.println(powerxN.myPow(2.1, 3));
        System.out.println(powerxN.myPow(2.0, -2));
    }


}
