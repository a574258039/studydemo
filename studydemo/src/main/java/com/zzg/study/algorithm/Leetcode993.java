package com.zzg.study.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 993. 二叉树的堂兄弟节点
 */
public class Leetcode993 {


    private Map<Integer, Integer> depth = new HashMap<>();
    private Map<Integer, TreeNode> parent = new HashMap<>();

    public boolean isCousins(TreeNode root, int x, int y) {
        depth.put(root.val, 0);
        parent.put(root.val, null);
        dfs(root, null);
        return depth.get(x).intValue() == depth.get(y).intValue() && parent.get(x) != parent.get(y);
    }

    private void dfs(TreeNode node, TreeNode par) {
        if (node == null) {
            return;
        }
        depth.put(node.val, par != null ? depth.get(par.val) + 1 : 0);
        parent.put(node.val, par);
        dfs(node.left, node);
        dfs(node.right, node);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */