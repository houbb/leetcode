package com.github.houbb.leetcode.F200T300;

import java.util.ArrayList;
import java.util.List;

public class T204_CountPrimes {

    /**
     * 线性算法
     *
     * https://cp-algorithms.com/algebra/prime-sieve-linear.html
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int count = 0;

        int[] lp = new int[n+1];
        List<Integer> pr = new ArrayList<>();

        for(int i = 2; i <= n; i++) {
            if(lp[i] == 0) {
                lp[i] = i;
                pr.add(i);

                // 严格小于
                if(i < n) {
                    count++;
                }
            }

            for (int j = 0; i * pr.get(j) <= n; ++j) {
                lp[i * pr.get(j)] = pr.get(j);
                if (pr.get(j) == lp[i]) {
                    break;
                }
            }
        }

        return count;
    }

}
