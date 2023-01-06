package com.github.houbb.leetcode.F100T200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T140_WordBreakII {

    public static void main(String[] args) {
        T140_WordBreakII wordBreak = new T140_WordBreakII();

        System.out.println(wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code")));
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
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> resultList = new ArrayList<>();

        // 存放字符串的子集
        List<String> tempList = new ArrayList<>();

        backtrack(s, wordDict, tempList, resultList);

        return resultList;
    }

    private void backtrack(String target,
                           List<String> wordDict,
                           List<String> tempList,
                           List<String> resultList) {
        // 终止条件
        String tempString = join(tempList, "");

        // 剪枝
        if(tempString.length() > target.length()) {
            return;
        } else if(tempString.equals(target)) {
            // 后来发现，并不需要用完所有的单词。
            // 这里不需要返回结果，只需要是否即可。
            resultList.add(join(tempList, " "));
            return;
        } else {
            // 拼接，可以从字典中任意取一个。可以重复使用
            for(String word : wordDict) {
                // 这里只选择匹配的字符串
                if(target.startsWith(word, tempString.length())) {
                    tempList.add(word);

                    // 回溯
                    backtrack(target, wordDict, tempList,  resultList);

                    // 移除最后一个
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }

    private String join(List<String> tempList,
                        String splitter) {
        if(tempList.size() <= 0) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < tempList.size()-1; i++) {
            stringBuilder.append(tempList.get(i))
                    .append(splitter);
        }
        stringBuilder.append(tempList.get(tempList.size()-1));

        return stringBuilder.toString();
    }

}
