package com.github.houbb.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class LongestPalindromicSubstringTest {

    @Test
    public void basicTest() {
        LongestPalindromicSubstring substring = new LongestPalindromicSubstring();

        Assert.assertEquals("bacab", substring.longestPalindrome("abacab"));
//        Assert.assertEquals("abcdefghgfedcba", substring.longestPalindrome("1abcdefghgfedcba"));
//        Assert.assertEquals("bab", substring.longestPalindrome("babad"));
//        Assert.assertEquals("bb", substring.longestPalindrome("cbbd"));
    }

}
