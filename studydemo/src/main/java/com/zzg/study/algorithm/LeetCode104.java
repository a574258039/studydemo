package com.zzg.study.algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode104 {




//    public int maxDepth(TreeNode node) {
//        if(node==null){
//            return 0;
//        }
//        return Math.max(maxDepth(node.left)+1,maxDepth(node.right)+1);
//    }
public int maxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int maxDepth = 1;
    Deque<TreeNode> treeNodes = new LinkedList<>();
    treeNodes.push(root);
    Deque<Integer> depth = new LinkedList<>();
    depth.push(1);
    while (!treeNodes.isEmpty()) {
        TreeNode tmp = treeNodes.pop();
        int currentDepth = depth.pop();
        maxDepth = currentDepth > maxDepth ? currentDepth : maxDepth;
        if (tmp.left != null) {
            treeNodes.push(tmp.left);
            depth.push(currentDepth+1);
        }
        if (tmp.right != null) {
            treeNodes.push(tmp.right);
            depth.push(currentDepth+1);
        }
    }
    return maxDepth;
}
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
