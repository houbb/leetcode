package com.github.houbb.leetcode.F100T200;

public class T191_NumberOf1Bits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String binary = Integer.toBinaryString(n);

        int c = 0;

        for(int i = 0; i < binary.length(); i++) {
            if('1' == binary.charAt(i)) {
                c++;
            }
        }
        return c;
    }

}
