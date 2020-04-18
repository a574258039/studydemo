package com.zzg.study.algorithm;

/**
 * 二叉树的最小深度
 */
public class LeetCode111 {


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left) + 1, minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right) + 1, minDepth);
        }
        return minDepth;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
