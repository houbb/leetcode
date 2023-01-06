package com.github.houbb.leetcode.F100T200;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T137_SingleNumberIIV2 {

    /**
     * Runtime: 3 ms, faster than 59.27% of Java online submissions for Single Number II.
     * Memory Usage: 38.5 MB, less than 85.23% of Java online submissions for Single Number II.
     *
     * @param nums 数字
     * @return 结果
     */
    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            // first appearence:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once
            // second appearance:
            // remove num from seen_once
            // add num to seen_twice
            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }
        return seenOnce;
    }

}
