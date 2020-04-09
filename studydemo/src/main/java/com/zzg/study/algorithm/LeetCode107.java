package com.zzg.study.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的层次遍历 广度优先算法
 */
public class LeetCode107 {


    public static void main(String[] args) {

//        TreeNode root0 = new TreeNode(0);
//        TreeNode node1 = new TreeNode(1);
//        root0.setLeft(node1);
//        TreeNode node2 = new TreeNode(2);
//        root0.setRight(node2);
//
//        TreeNode node3 = new TreeNode(3);
//        node1.setLeft(node3);
//        TreeNode node4 = new TreeNode(4);
//        node1.setRight(node4);
//        List<List<Integer>> list = new LeetCode107().levelOrderBottom(root0);
//        System.out.printf("" + list);

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        /** 结果 **/
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int f = queue.size();
            List<Integer> innerList = new ArrayList<>();
            for (int i = 0; i < f; i++) {

                TreeNode node = queue.poll();
                innerList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            stack.push(innerList);
        }
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }


}




