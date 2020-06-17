package com.github.houbb.leetcode;

import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class GenerateParenthesesTest {

    @Test
    public void bfTest() {
        GenerateParenthesesBF generateParentheses = new GenerateParenthesesBF();

        System.out.println(generateParentheses.generateParenthesis(3));
    }

    @Test
    public void dfsTest() {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3));
    }

    @Test
    public void sizeTest() {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        for(int i = 1; i < 10; i++) {
            System.out.println(generateParentheses.generateParenthesis(i).size());
            System.out.println("--" + Math.pow(3, i));
        }
    }

    @Test
    public void optimizeTest() {
        GenerateParenthesesOptimize optimize = new GenerateParenthesesOptimize();
        System.out.println(optimize.generateParenthesis(3));
    }

}
