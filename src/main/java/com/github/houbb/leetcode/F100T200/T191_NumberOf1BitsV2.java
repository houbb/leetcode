package com.github.houbb.leetcode.F100T200;

public class T191_NumberOf1BitsV2 {

    // you need to treat n as an unsigned value
    // https://leetcode.com/problems/number-of-1-bits/solutions/55099/simple-java-solution-bit-shifting/?orderBy=most_votes

    /**
     * An Integer in Java has 32 bits, e.g. 00101000011110010100001000011010.
     *
     * To count the 1s in the Integer representation we put the input int
     * n in bit AND with 1 (that is represented as 00000000000000000000000000000001, and if this operation result is 1, that means that the last bit of the input integer is 1. Thus we add it to the 1s count.
     *
     * ones = ones + (n & 1);
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int ones = 0;

        while (n != 0) {
            //n & 1，同为1，才是1
            ones = ones + (n & 1);
            n = n >>> 1;
        }
        return ones;
    }

}
