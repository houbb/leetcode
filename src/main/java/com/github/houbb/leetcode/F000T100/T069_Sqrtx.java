package com.github.houbb.leetcode.F000T100;

public class T069_Sqrtx {

    /**
     * math.sqrt 的实现原理到底是什么？
     *
     * 最简单的方式，从 i=1开始迭代
     * @param x 数字
     * @return 结果
     */
    public int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }

        for(int i = 1; i <= x; i++) {
            // 用除法，替代乘法，避免越界
            int div = x / i;
            if(div == i) {
                return i;
            }
            if(div < i) {
                return i-1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        T069_Sqrtx sqrtx = new T069_Sqrtx();

        System.out.println(sqrtx.mySqrt(4));
        System.out.println(sqrtx.mySqrt(8));
    }

}
