package com.github.houbb.leetcode.F200T300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class MajorityElementIIMoerVote {

    /**
     * Runtime: 8 ms, faster than 29.02% of Java online submissions for Majority Element II.
     * Memory Usage: 42.3 MB, less than 78.51% of Java online submissions for Majority Element II.
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        int one = nums[0];
        int two = nums[0];
        int countOne = 0;
        int countTwo = 0;

        for(int n : nums) {
            // 投票
            if(one == n) {
                countOne++;
                continue;
            }
            if(two == n) {
                countTwo++;
                continue;
            }

            // 第1个候选人配对
            if (countOne == 0) {
                one = n;
                countOne++;
                continue;
            }
            // 第2个候选人配对
            if (countTwo == 0) {
                two = n;
                countTwo++;
                continue;
            }

            // 其他情况，二者都抵消
            countOne--;
            countTwo--;
        }

        // 计数阶段
        countOne = 0;
        countTwo = 0;

        for(int n : nums) {
            if(n == one) {
                countOne++;
            }
            if(n == two) {
                countTwo++;
            }
        }


        int limit = nums.length / 3;
        List<Integer> results = new ArrayList<>();
        if(countOne > limit) {
            results.add(one);
        }
        if(countTwo > limit) {
            results.add(two);
        }
        // 添加元素
        return results;
    }

}
