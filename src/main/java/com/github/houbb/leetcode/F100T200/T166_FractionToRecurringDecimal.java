package com.github.houbb.leetcode.F100T200;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class T166_FractionToRecurringDecimal {

    public static void main(String[] args) {
        T166_FractionToRecurringDecimal fraction = new T166_FractionToRecurringDecimal();

        System.out.println(fraction.fractionToDecimal(1, 2));
    }

    /**
     * https://leetcode.com/problems/fraction-to-recurring-decimal/solutions/1669777/accepted-simple-solution-with-step-by-step-detailed-explaination/
     *
     * So we can divide this question in three parts :
     *
     * Division with its own multiple for eg. 8 / 4 = 2
     * Division without repeating numbers after decimal for eg. 41 / 2 = 20.5
     * Division with repeating numbers after decimal for eg. 14 / 3 = 4.(6) or 47 / 18 = 2.6(1)
     * Note : Here the repeating part is in bracket.
     * For 1st Part we can normally divide the numbers and add it to the ans string and return if the remainder is 0.
     *
     * //Code:
     * int q = num / den;
     * int r = num % den;
     * ans += q;
     * if(r == 0) return ans;
     *
     *
     * For 2nd part we need to add a “.” if remainder is not zero and then make the remainder 10 times everytime and append the quotient to the ans string.
     *
     * //Code:
     * while(r != 0)
     * 	r *= 10;
     * 	q = r / den;
     * 	r = r % den;
     * 	ans += q;
     *
     * 	For the 3rd part we need to use and unordered_map so that we can store the the position from where the repeating of number starts in front of the remainder.
     * 	If the remainder is already in the map then we insert the “(” opening bracket at the position of that rem and lastly append a “)”
     * 	closing bracket and break out of the loop and return the ans.
     *
     *  //Code :
     * unordered_map<int, int> mp;
     * while(r != 0)
     * 	if(mp(r) is in map)
     * 		int pos = mp[r];
     * 		ans.insert(pos, "(");
     * 		ans += ')';
     * 		break;
     * 	else
     * 		mp[r] = ans.length();
     * 		r *= 10;
     * 		q = r / den;
     * 		r = r % den;
     * 		ans += q;
     *
     *
     * 	Now it will give runtime error for cases like -1 / -2147483648 so we need to change the int to long
     *
     * long num = labs(numerator), den = labs(denominator);
     * long q = num / den;
     * long r = num % den;
     *
     * and
     *
     * unordered_map<long, int> mp;
     *
     * We need to handle the case where there are negative numbers.
     *
     * So if numerator is negative and denominator is positive or numerator is positive and denominator is negative we need to add a “-“ negative symbol in the ans.
     *
     * if (numerator > 0 ^ denominator > 0)
     * 	ans += '-';
     *
     *
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorL = Math.abs((long) numerator);
        long denominatorL = Math.abs((long) denominator);
        StringBuilder sb = new StringBuilder();

        // 整数部分
        long quotian = numeratorL / denominatorL;
        sb.append(quotian);

        numeratorL %= denominatorL;

        // 存在小数部分
        if (numeratorL != 0) {
            sb.append(".");
        }

        Map<Long, Integer> previousRemains = new HashMap<>();
        int quotianIndex = 0;
        while (numeratorL != 0) {
            numeratorL *= 10;
            quotian = Math.abs(numeratorL / denominatorL);
            if (!previousRemains.containsKey(numeratorL)) {
                sb.append(quotian);
                previousRemains.put(numeratorL, quotianIndex++);
            } else {
                int firstIndex = 1 + previousRemains.get(numeratorL) + sb.indexOf(".");
                sb.insert(firstIndex, '(');
                sb.append(")");
                break;
            }
            numeratorL %= denominatorL;
        }

        // 处理负数
        boolean isNegative = numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0;
        if (isNegative) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }

}
