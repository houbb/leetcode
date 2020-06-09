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

        Assert.assertEquals("pbqbp", substring.longestPalindrome("slvafhpfjpbqbpcuwxuexavyrtymfydcnvvbvdoitsvumbsvoayefsnusoqmlvatmfzgwlhxtkhdnlmqmyjztlytoxontggyytcezredlrrimcbkyzkrdeshpyyuolsasyyvxfjyjzqksyxtlenaujqcogpqmrbwqbiaweacvkcdxyecairvvhngzdaujypapbhctaoxnjmwhqdzsvpyixyrozyaldmcyizilrmmmvnjbyhlwvpqhnnbausoyoglvogmkrkzppvexiovlxtmustooahwviluumftwnzfbxxrvijjyfybvfnwpjjgdudnyjwoxavlyiarjydlkywmgjqeelrohrqjeflmdyzkqnbqnpaewjdfmdyoazlznzthiuorocncwjrocfpzvkcmxdopisxtatzcpquxyxrdptgxlhlrnwgvee"));
        Assert.assertEquals("bb", substring.longestPalindrome("abcdbbfcba"));
        Assert.assertEquals("bacab", substring.longestPalindrome("abacab"));
        Assert.assertEquals("abcdefghgfedcba", substring.longestPalindrome("1abcdefghgfedcba"));
        Assert.assertEquals("aba", substring.longestPalindrome("babad"));
        Assert.assertEquals("bb", substring.longestPalindrome("cbbd"));
    }

    @Test
    public void palindromeTest() {
        LongestPalindromicSubstring substring = new LongestPalindromicSubstring();

        Assert.assertTrue(LongestPalindromicSubstring.isPalindrome("pbqbp"));
        Assert.assertTrue(LongestPalindromicSubstring.isPalindrome("bb"));
        Assert.assertTrue(LongestPalindromicSubstring.isPalindrome("bacab"));
        Assert.assertTrue(LongestPalindromicSubstring.isPalindrome("abcdefghgfedcba"));
        Assert.assertTrue(LongestPalindromicSubstring.isPalindrome("bab"));
//        Assert.assertEquals("pbqbp", substring.longestPalindrome("slvafhpfjpbqbpcuwxuexavyrtymfydcnvvbvdoitsvumbsvoayefsnusoqmlvatmfzgwlhxtkhdnlmqmyjztlytoxontggyytcezredlrrimcbkyzkrdeshpyyuolsasyyvxfjyjzqksyxtlenaujqcogpqmrbwqbiaweacvkcdxyecairvvhngzdaujypapbhctaoxnjmwhqdzsvpyixyrozyaldmcyizilrmmmvnjbyhlwvpqhnnbausoyoglvogmkrkzppvexiovlxtmustooahwviluumftwnzfbxxrvijjyfybvfnwpjjgdudnyjwoxavlyiarjydlkywmgjqeelrohrqjeflmdyzkqnbqnpaewjdfmdyoazlznzthiuorocncwjrocfpzvkcmxdopisxtatzcpquxyxrdptgxlhlrnwgvee"));
//        Assert.assertEquals("bb", substring.longestPalindrome("abcdbbfcba"));
//        Assert.assertEquals("bacab", substring.longestPalindrome("abacab"));
//        Assert.assertEquals("abcdefghgfedcba", substring.longestPalindrome("1abcdefghgfedcba"));
//        Assert.assertEquals("bab", substring.longestPalindrome("babad"));
//        Assert.assertEquals("bb", substring.longestPalindrome("cbbd"));
    }

}
