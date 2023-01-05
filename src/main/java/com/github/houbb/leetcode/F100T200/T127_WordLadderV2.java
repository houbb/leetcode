package com.github.houbb.leetcode.F100T200;

import java.util.*;

public class T127_WordLadderV2 {

    public static void main(String[] args) {
//        System.out.println(new T126_WordLadderII().findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
//        System.out.println(new T126_WordLadderII().findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
//        System.out.println(new T126_WordLadderII().findLadders("hot", "dog", Arrays.asList("hot","dog","dot")));
        System.out.println(new T127_WordLadderV2().ladderLength("be", "ko", Arrays.asList("ce","mo","ko","me","co")));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) {
            return 0;
        }

        return search(beginSet, endSet, wordSet, 1);
    }

    private int search(Set<String> beginSet, Set<String> endSet, Set<String> wordSet, int result){
        if(beginSet.isEmpty() || endSet.isEmpty()) {
            return 0;
        }

        result++;
        wordSet.removeAll(beginSet);

        Set<String> nextSet = new HashSet<>();
        for(String str : beginSet){
            char[] chs = str.toCharArray();
            for(int i = 0; i < chs.length; i++){
                char c = chs[i];
                for(char j = 'a'; j <= 'z'; j++){
                    chs[i] = j;
                    String tmp = new String(chs);
                    if(!wordSet.contains(tmp)) {
                        continue;
                    }
                    if(endSet.contains(tmp)) {
                        return result;
                    }
                    nextSet.add(tmp);
                }
                chs[i] = c;
            }
        }

        return nextSet.size() > endSet.size() ? search(endSet, nextSet, wordSet, result) : search(nextSet, endSet, wordSet, result);
    }

}
