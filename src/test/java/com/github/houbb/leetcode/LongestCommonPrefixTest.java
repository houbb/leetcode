package com.github.houbb.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p> project: leetcode-LongestCommonPrefixTest </p>
 * <p> create on 2020/6/11 22:32 </p>
 *
 * @author binbin.hou
 * @since v1
 */
public class LongestCommonPrefixTest {

    @Test
    public void test() {
        LongestCommonPrefix prefix = new LongestCommonPrefix();

        Assert.assertEquals("fl", prefix.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        Assert.assertEquals("", prefix.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

}
