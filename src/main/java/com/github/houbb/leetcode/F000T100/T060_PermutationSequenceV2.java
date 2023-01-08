package com.github.houbb.leetcode.F000T100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author d
 * @since 1.0.0
 */
public class T060_PermutationSequenceV2 {

    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            factorial[i] = sum;
        }

        System.out.println("factorial: " + Arrays.toString(factorial));
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        for(int i=1; i<=n; i++){
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}
        k--;

        for(int i = 1; i <= n; i++){
            int index = k/factorial[n-i];
            sb.append(numbers.get(index));
            System.out.println("SB:" + sb.toString() + ", index: " + index + ", k: " + k + ", nums: " + numbers);
            numbers.remove(index);
            k-=index*factorial[n-i];
        }

        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        T060_PermutationSequenceV2 ps = new T060_PermutationSequenceV2();
        System.out.println(ps.getPermutation(4, 14));
    }

}
