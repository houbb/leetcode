package com.github.houbb.leetcode.F200T300;

public class T201_BitwiseAndOfNumbersRangeV2 {

    public static void main(String[] args) {
        T201_BitwiseAndOfNumbersRangeV2 range = new T201_BitwiseAndOfNumbersRangeV2();
        int r = range.rangeBitwiseAnd(1, 2147483647);
        System.out.println(r);
    }

    /**
     *
     * 本质：
     *
     * 寻找，left right 相同的前缀
     *
     * https://leetcode.com/problems/bitwise-and-of-numbers-range/solutions/593317/simple-3-line-java-solution-faster-than-100/
     *
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd(int left, int right) {
        int i = 0;
        while (left != right){
            left >>= 1;
            right >>= 1;

            i++;
        }
        return right << i;
    }

}
