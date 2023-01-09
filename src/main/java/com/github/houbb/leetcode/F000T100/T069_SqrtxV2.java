package com.github.houbb.leetcode.F000T100;

public class T069_SqrtxV2 {

    /**
     * math.sqrt 的实现原理到底是什么？
     *
     * 最简单的方式，从 i=1开始迭代
     *
     * 开始节点，直接从 2/x 开始
     *
     * I think this problem's key point is that we want to find the largest number, which num*num <= x,
     * therefore we should use the binary search to find the upper bound within the range(1,x).
     *
     * Different people may have their own way handling the boundaries, but I figure we'd better think clearly what we want to find through binary search.
     * Below is my code, just a typical template of using upper bound of binary search
     * Hope it helps my bros
     *
     * @param x 数字
     * @return 结果
     */
    public int mySqrt(int x) {
        int i = 1;
        int j = x;
        int ans = 0;

        while (i <=j){
            int mid = i + (j-i)/2;
            // upper bound的形式，因为我们要找的ans要是最接近于x的最大的数，利用upper bound
            if (mid <= x/mid){
                i = mid +1;
                ans = mid;
            }
            else {
                j = mid-1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        T069_SqrtxV2 sqrtx = new T069_SqrtxV2();

        System.out.println(sqrtx.mySqrt(4));
        System.out.println(sqrtx.mySqrt(8));
    }

}
