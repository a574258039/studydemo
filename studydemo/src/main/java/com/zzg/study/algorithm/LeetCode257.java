package com.zzg.study.algorithm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode257 {


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<String> linkList = new LinkedList<>();
        Deque<TreeNode> nodeList = new LinkedList<>();
        linkList.push(String.valueOf(root.val));
        nodeList.push(root);
        while (!nodeList.isEmpty()) {
            TreeNode node = nodeList.poll();
            String s = linkList.pop();
            if (node.left != null) {
                linkList.push(new StringBuilder(s).append("->").append(node.left.val).toString());
                nodeList.push(node.left);
            }
            if (node.right != null) {
                linkList.push(new StringBuilder(s).append("->").append(node.right.val).toString());
                nodeList.push(node.right);
            }
            if (node.left == null && node.right == null) {
                result.add(s);
            }
        }
        return result;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
