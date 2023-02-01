package com.github.houbb.leetcode.F200T300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T204_CountPrimesV2 {

    /**
     * 经典算法
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
        Arrays.fill(isPrimes, true);
        isPrimes[0] = false;
        isPrimes[1] = false;

        for(int i = 2; i <= n; i++) {
            if(isPrimes[i] && (long)i * i <= n) {
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
