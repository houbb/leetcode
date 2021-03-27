package com.github.houbb.leetcode.F200T300;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class NumberOfDigitOneMath {

    int countDigitOne(int n) {
        if (n < 1) {
            return 0;
        }

        long digit = 1;
        int high = n / 10, current = n % 10, low = 0;
        int count = 0;

        while (high != 0 || current != 0) {
            if (current == 0) {
                count += high * digit;
            }
            else if (current == 1) {
                count += high * digit + low + 1;
            }
            else {
                count += (high + 1) * digit;
            }

            // 更新
            low += current * digit;
            current = high % 10;
            high /= 10;
            digit *= 10;
        }

        return count;
    }

}
