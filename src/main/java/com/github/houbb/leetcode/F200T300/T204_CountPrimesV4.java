package com.github.houbb.leetcode.F200T300;

import java.util.Arrays;

public class T204_CountPrimesV4 {

    /**
     * 经典算法-改进，只看奇数位。
     *
     * https://cp-algorithms.com/algebra/prime-sieve-linear.html
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if(n <= 2) {
            return 0;
        }

        boolean[] isPrimes = new boolean[n+1];
        for(int i = 0; i < n; i++) {
            if(i % 2 != 0) {
                // 偶数位全为false
                isPrimes[i] = true;
            }
        }
        // 2 是特例
        isPrimes[2] = true;

        for(int i = 2; i*i <= n; i++) {
            if(isPrimes[i]) {
                // 把一个基本数的倍数，全部置为 false
                for (int j = i * i; j <= n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }

        // 计算总数
        int count = 0;
        for(int i = 0; i < isPrimes.length; i++) {
            if(isPrimes[i] && i < n) {
                count++;
            }
        }
        return count;
    }

}
