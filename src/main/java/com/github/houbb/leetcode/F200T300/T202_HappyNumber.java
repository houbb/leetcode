package com.github.houbb.leetcode.F200T300;

public class T202_HappyNumber {

    public static void main(String[] args) {
        T202_HappyNumber happyNumber = new T202_HappyNumber();

//        System.out.println(happyNumber.isHappy(19));
//        System.out.println(happyNumber.isHappy(2));
        System.out.println(happyNumber.isHappy(7));
    }

    /**
     * 超时
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        if(n == 1 || n == 7) {
            return true;
        }

        int len = String.valueOf(n).length();
        int sum = calc(n, len);

        // 终止条件？
        while (sum >= 10) {
            sum = calc(sum, len);
        }

        return sum == 1 || sum == 7;
    }

    private int calc(int n, int len) {
        String sn = String.valueOf(n);

        int sum = 0;

        for(int i = 0; i < sn.length(); i++) {
            int num = Integer.parseInt(String.valueOf(sn.charAt(i)));
            sum += Math.pow(num, len);
        }
        return sum;
    }

}
