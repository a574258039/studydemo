package com.zzg.study.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode559 {

    public int maxDepth(Node root) {

        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int i = queue.size();
            while (i > 0) {
                Node node = queue.poll();
                if (node.children != null && node.children.size() > 0) {
                    for (Node n : node.children) {
                        queue.add(n);
                    }
                }
                i--;
            }
            maxDepth++;
        }
        return maxDepth;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
