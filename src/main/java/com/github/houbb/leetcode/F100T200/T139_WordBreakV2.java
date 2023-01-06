package com.github.houbb.leetcode.F100T200;

import java.util.*;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T139_WordBreakV2 {

    public static void main(String[] args) {
        T139_WordBreakV2 wordBreak = new T139_WordBreakV2();

        System.out.println(wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code")));
//        System.out.println(wordBreak.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
//        System.out.println(wordBreak.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
//        System.out.println(wordBreak.wordBreak("bccdbacdbdacddabbaaaadababadad", Arrays.asList("cbc","bcda","adb","ddca","bad","bbb","dad","dac","ba","aa","bd","abab","bb","dbda","cb","caccc","d","dd","aadb","cc","b","bcc","bcd","cd","cbca","bbd","ddd","dabb","ab","acd","a","bbcc","cdcbd","cada","dbca","ac","abacd","cba","cdb","dbac","aada","cdcda","cdc","dbc","dbcb","bdb","ddbdd","cadaa","ddbc","babb")));
        System.out.println(wordBreak.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
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


        //2. 第二个问题，如果很长的一个字符串，最后一个却不存在。
        // 那么可否把 s 进行拆分去重？
        // 但是感觉这样也是指标不治本
        boolean fastFailed = fastFailed(s, wordDict);
        if(!fastFailed) {
            return false;
        }

        // 调整 wordDict 的顺序，把长度较长的放在前面。便于 greedy。
        Collections.sort(wordDict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        // 存放字符串的子集
        List<String> tempList = new ArrayList<>();

        // 回溯問題？
        backtrack(s, wordDict, tempList, resultList);

        // 全部使用到了
        return resultList.size() > 0;
    }

    private boolean fastFailed(String s, List<String> wordDict) {
        Set<Character> targetSet = getCharSet(s);
        Set<Character> wordSet = getCharSet(buildString(wordDict));

        for(Character character : targetSet) {
            if(!wordSet.contains(character)) {
                return false;
            }
        }

        return true;
    }

    private Set<Character> getCharSet(String text) {
        char[] chars = text.toCharArray();

        Set<Character> set = new HashSet<>();
        for(char c : chars) {
            set.add(c);
        }
        return set;
    }

    private void backtrack(String target, List<String> wordDict,
                           List<String> tempList,
                           List<String> resultList) {
        // 终止条件
        String tempString = buildString(tempList);
        // 剪枝
        if(tempString.length() > target.length()
            || !target.startsWith(tempString)) {
            return;
        } else if(tempString.equals(target)) {
            // 后来发现，并不需要用完所有的单词。
            // 这里不需要返回结果，只需要是否即可。
            resultList.addAll(new ArrayList<>(tempList));
            return;
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
