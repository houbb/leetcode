package com.github.houbb.leetcode.F200T300;

import java.util.HashSet;
import java.util.Set;

/**
 * 是否存在重复元素
 *
 * @since 20231117
 */
public class T217_ContainsDuplicateV2Bit {

    public boolean containsDuplicate(int[] nums) {
        int checker = 0;
        for (int num : nums) {
            int mask = 1 << num;
            if ((checker & mask) != 0) {
                return true; // 数字重复出现
            }
            checker |= mask;
        }
        return false; // 数字没有重复出现
    }

    public static void main(String[] args) {
        T217_ContainsDuplicateV2Bit containsDuplicate = new T217_ContainsDuplicateV2Bit();
        boolean result = containsDuplicate.containsDuplicate(new int[]{1,2,3,1});
        System.out.println(result);
    }

}
