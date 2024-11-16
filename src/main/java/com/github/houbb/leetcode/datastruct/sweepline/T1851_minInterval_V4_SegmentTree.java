package com.github.houbb.leetcode.datastruct.sweepline;

import java.util.Arrays;
import java.util.PriorityQueue;

public class T1851_minInterval_V4_SegmentTree {

    public int[] minInterval(int[][] intervals, int[] queries) {
        Node root = new Node(1, (int)1e7);
        for(int[] in:intervals){
            root.update(in[0],in[1],in[1]-in[0]+1);
        }
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int cur = root.query(queries[i], queries[i]);
            ans[i] = cur==Integer.MAX_VALUE?-1:cur;
        }

        return ans;
    }

    class Node{
        int left;
        int right;
        int val;
        int mark;
        Node leftNode;
        Node rightNode;

        public Node(int l, int r){
            left = l;
            right = r;
            val = Integer.MAX_VALUE;
            mark = Integer.MAX_VALUE;
        }

        public Node getLeftNode(){
            if (leftNode==null){
                leftNode = new Node(left, left+(right-left)/2);
            }
            return leftNode;
        }

        public Node getRightNode(){
            if(rightNode==null){
                rightNode = new Node(left+(right-left)/2+1, right);
            }
            return rightNode;
        }

        public void update(int lo, int hi, int v){
            if(left>hi||right<lo||v>=val){
                return;
            }
            if(left>=lo&&right<=hi){
                val = v;
                mark = v;
                return;
            }
            pushDown();
            getLeftNode().update(lo,hi,v);
            getRightNode().update(lo,hi,v);
        }

        public int query(int lo, int hi){
            if(left>hi||right<lo){
                return Integer.MAX_VALUE;
            }
            if(left>=lo&&right<=hi){
                return val;
            }
            pushDown();
            return Math.min(getLeftNode().query(lo,hi), getRightNode().query(lo,hi));
        }

        public void pushDown(){
            if(mark != Integer.MAX_VALUE){
                getLeftNode().val = Math.min(leftNode.val, mark);
                getRightNode().val = Math.min(rightNode.val, mark);
                getLeftNode().mark = Math.min(leftNode.mark, mark);
                getRightNode().mark = Math.min(rightNode.mark, mark);
                mark = Integer.MAX_VALUE;
            }
        }
    }

}
