package com.github.houbb.leetcode.F200T300;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class NumberOfDigitOne {

    public static void main(String[] args) {
        System.out.println(countDigitOne(0));
        System.out.println(countDigitOne(13));
    }

    /**
     * 最基本的思路：
     *
     * 直接统计各个位数的信息。
     * @param n
     * @return
     */
    public static int countDigitOne(int n) {
        int sum = 0;

        for(int i = 1; i <= n; i++){
            sum += countOne(i);
        }

        return sum;
    }

    // 可以用除法，也可以转换为字符串处理。
    private static int countOne(int n) {
        int count = 0;

        String string = n+"";
        char[] chars = string.toCharArray();
        for(char c : chars){
            if(c == '1') {
                count++;
            }
        }

        return count;
    }

}
