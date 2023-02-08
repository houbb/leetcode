package com.github.houbb.leetcode.F000T100;

import java.util.Stack;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T071_SimplifyPath {

    /**
     * 优化思路：不适用正则表达式拆分。
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        Stack<String> stringStack = new Stack<>();

        char[] chars = path.toCharArray();
        StringBuilder tempBuild = new StringBuilder();
        for(char c : chars) {
            if('/' == c) {
                handleTemp(stringStack, tempBuild);
            } else {
                tempBuild.append(c);
            }
        }
        // 最后的处理
        handleTemp(stringStack, tempBuild);

        if(stringStack.isEmpty()) {
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder(stringStack.size());
        for(String p : stringStack) {
            stringBuilder.append("/").append(p);
        }
        return stringBuilder.toString();
    }

    private void handleTemp(final Stack<String> stringStack, StringBuilder tempBuild) {
        String temp = tempBuild.toString();
        if(temp.length() == 0) {
            return;
        }

        tempBuild.delete(0, temp.length());

        if("..".equals(temp)) {
            if(!stringStack.isEmpty()) {
                stringStack.pop();
            }
        } else if(!".".equals(temp)) {
            stringStack.push(temp);
        }
    }

    /**
     * 解题思路：
     *
     * 直接根据 / 分割。（当然直接使用正向遍历，肯定比 regex 要快）
     *
     * 跳过 . ""
     *
     * 如果遇到 ..，就把上一个信息弹出。
     *
     * 最后将 stack 中的元素拼接即可。
     *
     * @param path
     * @return
     */
    public String simplifyPath2(String path) {
        String[] strings = path.split("/");

        Stack<String> stringStack = new Stack<>();
        for(String string : strings) {
            if("..".equals(string)) {
                if(!stringStack.isEmpty()) {
                    stringStack.pop();
                }
            } else if(!"".equals(string) && !".".equals(string)) {
                stringStack.push(string);
            }
        }

        if(stringStack.isEmpty()) {
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder(stringStack.size());
        for(String p : stringStack) {
            stringBuilder.append("/").append(p);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        T071_SimplifyPath path = new T071_SimplifyPath();
        System.out.println(path.simplifyPath("/home/"));
        System.out.println(path.simplifyPath("/../"));
        System.out.println(path.simplifyPath("/home//foo/"));
        System.out.println(path.simplifyPath("/a/./b/../../c/"));
    }

}
