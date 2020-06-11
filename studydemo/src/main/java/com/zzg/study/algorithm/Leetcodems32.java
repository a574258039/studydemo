package com.zzg.study.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcodems32 {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            LinkedList<TreeNode> temp = new LinkedList<>();
            temp.add(root);
            while (!temp.isEmpty()) {
                int size = temp.size();
                List<Integer> list = new ArrayList<>();
                while (size > 0) {
                    TreeNode node = temp.poll();
                    if (node.left != null) {
                        temp.add(node.left);
                    }
                    if (node.right != null) {
                        temp.add(node.right);
                    }
                    list.add(node.val);
                    size--;
                }
                result.add(list);
            }
        }
        return result;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}