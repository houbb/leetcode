package com.github.houbb.leetcode.topics.sort;

import java.util.*;

public class Sort_T451_FreqSort_V2_HashMapOpt {


    private class Node {
        private Character character;
        private int count;

        public Node(Character character, int count) {
            this.character = character;
            this.count = count;
        }
    }

    public String frequencySort(String s) {
        if (s.length() <= 1) {
            return s;
        }

        Map<Character, Integer> freqCountMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            Integer count = freqCountMap.getOrDefault(c, 0);
            freqCountMap.put(c, ++count);
        }

        // 怎么按照次数排序呢？
        // 排序和大小堆的复杂度都是 OlogN()
        List<Node> nodeList = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : freqCountMap.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            nodeList.add(node);
        }
        Collections.sort(nodeList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.count - o1.count;
            }
        });

        // 处理
        StringBuffer stringBuffer = new StringBuffer();
        for (Node node : nodeList) {
            for (int i = 0; i < node.count; i++) {
                stringBuffer.append(node.character);
            }
        }

        return stringBuffer.toString();
    }

}
