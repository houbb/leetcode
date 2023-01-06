package com.github.houbb.leetcode.F100T200;

import java.util.*;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T139_WordBreak {

    public static void main(String[] args) {
        T139_WordBreak wordBreak = new T139_WordBreak();

        System.out.println(wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wordBreak.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(wordBreak.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }

    /**
     *
     * 1 <= wordDict.length <= 1000
     * 1 <= wordDict[i].length <= 20
     *
     * 单词的长度可能比较长，单词词库的数量有限。
     *
     * 感觉可以反过来思考：
     *
     * 1. 从词典中选择一个词，构建字符串
     * 2. 从词典中继续选择一个词（单词可以复用，不需要移除）， 构建字符串剩余的部分
     * 3. 使用 backtrack
     *
     * @param s 目标
     * @param wordDict 单词库
     * @return 结果
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        List<String> resultList = new ArrayList<>();

        // 存放字符串的子集
        List<String> tempList = new ArrayList<>();

        // 回溯問題？
        backtrack(s, wordDict, tempList, resultList);

        // 全部使用到了
        return resultList.size() > 0;
    }

    private void backtrack(String target, List<String> wordDict,
                           List<String> tempList,
                           List<String> resultList) {
        // 终止条件
        String tempString = buildString(tempList);
        // 剪枝
        if(tempString.length() > target.length()) {
            return;
        } else if(tempString.equals(target)) {
            // 后来发现，并不需要用完所有的单词。
            // 这里不需要返回结果，只需要是否即可。
            resultList.addAll(new ArrayList<>(tempList));
            return;

            // 拼接完成，而且刚好用完所有的单词，当然，这里可以当做一个变形。
            /*Set<String> tempSet = new HashSet<>(tempList);
            if(wordDict.size() == tempSet.size()) {
                // 这里不需要返回结果，只需要是否即可。
                resultList.addAll(new ArrayList<>(tempList));
                return;
            }*/
        } else {
            // 剪枝
            if(resultList.size() > 0) {
                return;
            }

            // 拼接，可以从字典中任意取一个。可以重复使用
            for(String word : wordDict) {
                tempList.add(word);

                // 回溯
                backtrack(target, wordDict, tempList,  resultList);

                // 移除最后一个
                tempList.remove(tempList.size()-1);
            }
        }
    }

    private String buildString(List<String> tempList) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String temp : tempList) {
            stringBuilder.append(temp);
        }

        return stringBuilder.toString();
    }

}
