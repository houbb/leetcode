package com.github.houbb.leetcode;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class DivideTwoIntegers {

    /**
     * 解题思路：这题是除法，所以先普及下除法术语
     * <p>
     * 商，公式是：(被除数-余数)÷除数=商，记作：被除数÷除数=商...余数，是一种数学术语。
     * 在一个除法算式里，被除数、余数、除数和商的关系为：(被除数-余数)÷除数=商，记作：被除数÷除数=商...余数，
     * 进而推导得出：【商×除数+余数=被除数】。
     * <p>
     * 要求商，我们首先想到的是减法，能被减多少次，那么商就为多少，但是明显减法的效率太低
     * <p>
     * 那么我们可以用位移法，因为计算机在做位移时效率特别高，向左移1相当于乘以2，向右位移1相当于除以2
     * <p>
     * 我们可以把一个dividend（被除数）先除以2^n，n最初为31，不断减小n去试探,当某个n满足dividend/2^n>=divisor时，
     * <p>
     * 表示我们找到了一个足够大的数，这个数*divisor是不大于dividend的，所以我们就可以减去2^n个divisor，以此类推
     * <p>
     * 我们可以以100/3为例
     * <p>
     * 2^n是1，2，4，8...2^31这种数，当n为31时，这个数特别大，100/2^n是一个很小的数，肯定是小于3的，所以循环下来，
     * <p>
     * 当n=5时，100/32=3, 刚好是大于等于3的，这时我们将100-32*3=4，也就是减去了32个3，接下来我们再处理4，同样手法可以再减去一个3
     * <p>
     * 所以一共是减去了33个3，所以商就是33
     * <p>
     * 这其中得处理一些特殊的数，比如divisor是不能为0的，Integer.MIN_VALUE和Integer.MAX_VALUE
     *
     *
     * 使用的位运算思想很赞。每次都从2^0+2^1+...开始逼近，当快要接近被除数时。再从2^0+2^1+...开始逼近。直到不能更近为止。
     *
     * @since v2
     */
    public int divideLong(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long t = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int result = 0;

        for (int i = 31; i >= 0; i--) {
            //找出足够大的数2^n*divisor
            if ((t >> i) >= d) {
                //将结果加上2^n
                result += 1 << i;
                //将被除数减去2^n*divisor
                t -= d << i;
            }
        }

        //符号相异取反
        return (dividend ^ divisor) < 0 ? -result : result;
    }


    public int divide(int A, int B) {
        if (A == Integer.MAX_VALUE && B == -1) {
            return Integer.MAX_VALUE;
        }

        int a = Math.abs(A), b = Math.abs(B), res = 0;
        for (int x = 31; x >= 0; x--) {
            if ((a >>> x) - b >= 0) {
                res += 1 << x;
                a -= b << x;
            }
        }
        return (A > 0) == (B > 0) ? res : -res;
    }

    /**
     * lnA - lnB = ln(A/B);
     *
     * Math.exp(x) 求 e^x 结果
     *
     * 二者互为反函数。
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divideLogAndExp(int dividend, int divisor) {
        double logAns = Math.log(Math.abs((double) dividend)) - Math.log(Math.abs((double) divisor));
        double answer = Math.exp(logAns);

        return (int) ((dividend ^ divisor) < 0 ? -answer : answer);
    }


    public int divideFoo(int dividend, int divisor) {
        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }
        return dividend / divisor;
    }

    public static void main(String[] args) {
        DivideTwoIntegers div = new DivideTwoIntegers();
        System.out.println(div.divideLong(100, 3));
    }

}
