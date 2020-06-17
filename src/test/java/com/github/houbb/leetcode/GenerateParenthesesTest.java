package com.github.houbb.leetcode;

import org.junit.Test;

/**
 *
 * https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
 *
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
        GenerateParenthesesDfs generateParenthesesDfs = new GenerateParenthesesDfs();
        System.out.println(generateParenthesesDfs.generateParenthesis(3));
    }

    @Test
    public void dfsMinusTest() {
        GenerateParenthesesDfsMinis generateParenthesesDfs = new GenerateParenthesesDfsMinis();
        System.out.println(generateParenthesesDfs.generateParenthesis(3));
    }

    @Test
    public void bfsTest() {
        GenerateParenthesesBfs bfs = new GenerateParenthesesBfs();
        System.out.println(bfs.generateParenthesis(3));
    }

    @Test
    public void sizeTest() {
        GenerateParenthesesDfs generateParenthesesDfs = new GenerateParenthesesDfs();
        for(int i = 1; i < 10; i++) {
            System.out.println(generateParenthesesDfs.generateParenthesis(i).size());
            System.out.println("--" + Math.pow(3, i));
        }
    }

    @Test
    public void optimizeTest() {
        GenerateParenthesesBacktrack optimize = new GenerateParenthesesBacktrack();
        System.out.println(optimize.generateParenthesis(3));
    }

    @Test
    public void dpTest() {
        GenerateParenthesesDp dp = new GenerateParenthesesDp();
        System.out.println(dp.generateParenthesis(3));
    }


}
