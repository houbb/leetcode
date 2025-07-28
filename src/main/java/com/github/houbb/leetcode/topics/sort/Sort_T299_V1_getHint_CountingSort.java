package com.github.houbb.leetcode.topics.sort;

public class Sort_T299_V1_getHint_CountingSort {

    public String getHint(String secret, String guess) {
        int len = secret.length();

        int bullCount = 0;

        // 数字的统计
        int[] secretCount = new int[10];
        int[] guessCount = new int[10];

        for(int i = 0; i < len; i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bullCount++;
            } else {
                secretCount[secret.charAt(i)-'0']++;
                guessCount[guess.charAt(i)-'0']++;
            }
        }

        // 数字对，但是位置不对？
        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCount[i], guessCount[i]);
        }

        return bullCount+"A"+cows+"B";
    }


    public static void main(String[] args) {
        Sort_T299_V1_getHint_CountingSort countingSort = new Sort_T299_V1_getHint_CountingSort();

        System.out.println(countingSort.getHint("1123", "0111"));;
    }

}
