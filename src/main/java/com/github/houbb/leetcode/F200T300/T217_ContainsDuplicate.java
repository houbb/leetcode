package com.github.houbb.leetcode.F200T300;

import java.util.HashSet;
import java.util.Set;

/**
 * 是否存在重复元素
 *
 * @since 20231117
 */
public class T217_ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        final Set<Integer> hashSet = new HashSet<>();

        for(int num : nums) {
            if(hashSet.contains(num)) {
                return true;
            }
            hashSet.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        T217_ContainsDuplicate containsDuplicate = new T217_ContainsDuplicate();
        boolean result = containsDuplicate.containsDuplicate(new int[]{1,2,3,1});
        System.out.println(result);
    }

}
