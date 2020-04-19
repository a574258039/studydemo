package com.zzg.study.algorithm;

public class Leetcode110 {

    public static void main(String[] args) {

        TreeNode node=new TreeNode(1);

        TreeNode node2L=new TreeNode(2);
        TreeNode node2R=new TreeNode(2);
        node.left=node2L;
        node.right=node2R;

        TreeNode node3L=new TreeNode(3);
        TreeNode node3R=new TreeNode(3);
        node2L.left=node3L;
        node2L.right=node3R;

        TreeNode node4L=new TreeNode(4);
        TreeNode node4R=new TreeNode(4);
        node3L.left=node4L;
        node3L.right=node4R;


        boolean result=new Leetcode110().isBalanced(node);
        System.out.printf(""+result);

    }


    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (Math.abs(height(root.left) - height(root.right)) >1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }


    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
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
