package com.github.houbb.leetcode.F200T300;

public class T201_BitwiseAndOfNumbersRange {

    public static void main(String[] args) {
        T201_BitwiseAndOfNumbersRange range = new T201_BitwiseAndOfNumbersRange();
        int r = range.rangeBitwiseAnd(1, 2147483647);
        System.out.println(r);
    }

    /**
     * 暴力运算，不可行。
     *
     * 会直接超时
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd(int left, int right) {
        int r = left;

        for(int i = left+1; i <= right; i++) {
            r = i & r;
        }

        return r;
    }

}
